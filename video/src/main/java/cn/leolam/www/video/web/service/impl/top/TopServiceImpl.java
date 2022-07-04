package cn.leolam.www.video.web.service.impl.top;

import cn.leolam.www.video.exception.top.TopException;
import cn.leolam.www.video.web.entities.User;
import cn.leolam.www.video.web.entities.Video;
import cn.leolam.www.video.web.mapper.VideoMapper;
import cn.leolam.www.video.web.service.top.TopService;
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
import java.util.List;
import java.util.Map;

/**
 * 排行榜服务
 */
@Service
@Slf4j
@Transactional
public class TopServiceImpl implements TopService {
    @Autowired
    VideoMapper videoMapper;
    @Autowired
    RestTemplateUtils restTemplateUtils;
    @Override
    public List<Video> getTopVideo(HttpServletRequest request) {
        List<Video> videoList = null;
        try {
            videoList = videoMapper.getSearchVideoByLikeSortTypeUserId(0, 10, null, "playCount",null);
            //获取author信息
            int length = videoList.size();
            HttpHeaders headers = new HttpHeaders();
            MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
            headers.add("Authorization", request.getHeader("Authorization"));
            //获取author
            for (int i = 0; i < length; i++) {
                Long author = (Long) videoList.get(i).getAuthor();
                params.add("id", String.valueOf(String.valueOf(author)));
                ResponseEntity<Map> responseEntity = restTemplateUtils.sendToAuthGetUserToken("/user/mine/setting/getUserById", headers, params);
                Map<String, String> map = responseEntity.getBody();
                String json = JSONObject.toJSONString(map.get("data"));
                User user = JSONObject.parseObject(json, User.class);
                videoList.get(i).setAuthor(user);
                params.clear();
            }
        } catch (Exception e) {
            log.info(e.getMessage());
            throw new TopException("排行榜查询错误");
        }
        return videoList;
    }
}
