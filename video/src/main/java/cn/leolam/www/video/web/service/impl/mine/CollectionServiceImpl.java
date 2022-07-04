package cn.leolam.www.video.web.service.impl.mine;

import cn.leolam.www.video.exception.mine.CollectionException;
import cn.leolam.www.video.properties.VideoProperties;
import cn.leolam.www.video.web.entities.CollectionList;
import cn.leolam.www.video.web.entities.User;
import cn.leolam.www.video.web.entities.Video;
import cn.leolam.www.video.web.mapper.CollectionListMapper;
import cn.leolam.www.video.web.mapper.VideoMapper;
import cn.leolam.www.video.web.service.mine.CollectionService;
import cn.leolam.www.video.web.utils.RestTemplateUtils;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
@Transactional
public class CollectionServiceImpl implements CollectionService {
    @Autowired
    CollectionListMapper collectionListMapper;

    @Autowired
    VideoMapper videoMapper;

    @Autowired
    RestTemplateUtils restTemplateUtils;

    @Autowired
    VideoProperties videoProperties;

    @Override
    public List<Video> getCollectionVideoListByUserId(Integer userId, Integer page, HttpServletRequest request) {
        List<Video> videoList = new ArrayList<>();
        try {
            if (page == 0) page = 1;
            Integer pageSize = videoProperties.getPageSizeOnCollectionPage();
            int start = (page - 1) * pageSize;
            //该用户收藏的列表
            List<CollectionList> collectionListList = collectionListMapper.getCollectionListsByUserId(userId, start, pageSize);
            int length = collectionListList.size();
            HttpHeaders headers = new HttpHeaders();
            MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
            headers.add("Authorization", request.getHeader("Authorization"));
            for (int i = 0; i < length; i++) {
                //视频信息
                Video video = videoMapper.getVideoById(Integer.parseInt(String.valueOf(collectionListList.get(i).getVideoId())));
                params.add("id", String.valueOf(String.valueOf(String.valueOf(collectionListList.get(i).getUserId()))));
                //用户信息
                ResponseEntity<Map> responseEntity = restTemplateUtils.sendToAuthGetUserToken("/user/mine/setting/getUserById", headers, params);
                Map<String, String> map = responseEntity.getBody();
                String json = JSONObject.toJSONString(map.get("data"));
                User user = JSONObject.parseObject(json, User.class);
                video.setAuthor(user);
                params.clear();
                videoList.add(video);
            }
        } catch (Exception e) {
            log.info(e.getMessage());
            throw new CollectionException("获取收藏列表失败");
        }
        return videoList;
    }

    @Override
    public Integer getAttentionCountByUserId(Integer userId) {
        Integer count = null;
        try {
            count = collectionListMapper.getCollectionListCountByUserId(userId);
        } catch (Exception e) {
            log.info(e.getMessage());
            throw new CollectionException("获取收藏总数失败");
        }
        return count;
    }

    @Override
    public Integer deleteCollectionListByVideoIdAndUserId(CollectionList collectionList) {
        Integer count = null;
        try {
            count = collectionListMapper.deleteCollectionListByCollectionList(collectionList);
            if(count!=1){
                throw new CollectionException("收藏取消失败");
            }
        }catch (Exception e){
            log.info(e.getMessage());
            throw new CollectionException("收藏取消失败");
        }
        return count;
    }
}
