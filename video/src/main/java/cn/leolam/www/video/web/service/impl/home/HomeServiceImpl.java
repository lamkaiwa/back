package cn.leolam.www.video.web.service.impl.home;

import cn.leolam.www.video.exception.home.HomeException;
import cn.leolam.www.video.properties.VideoProperties;
import cn.leolam.www.video.web.entities.User;
import cn.leolam.www.video.web.entities.Video;
import cn.leolam.www.video.web.mapper.TypeMapper;
import cn.leolam.www.video.web.mapper.VideoMapper;
import cn.leolam.www.video.web.service.home.HomeService;
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

@Service
@Slf4j
@Transactional
public class HomeServiceImpl implements HomeService {
    @Autowired
    VideoProperties videoProperties;

    @Autowired
    RestTemplateUtils restTemplateUtils;

    @Autowired
    VideoMapper videoMapper;

    @Autowired
    TypeMapper typeMapper;

    @Override
    public List<Video> getLimitVideoOrderByPlayCount(Integer page, HttpServletRequest request, Integer type) {
        List<Video> videoList = null;
        try {
            if (page == 0) page = 1;
            Integer pageSize = videoProperties.getPageSizeOnHomePage();
            int start = (page - 1) * pageSize;
            videoList = videoMapper.getLimitTypeVideoOrderByPlayCount(start, pageSize, type);
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
            throw new HomeException("视频获取异常");
        }
        return videoList;
    }

    @Override
    public Integer getAllVideoCountByType(Integer type) {
        Integer res = null;
        try {
            res = videoMapper.getAllVideoCountByType(type);
        } catch (Exception e) {
            log.info(e.getMessage());
            throw new HomeException("视频获取错误");
        }
        return res;
    }

    @Override
    public List<Video> getLunBoPic() {
        List<Video> videoList = null;
        try {
            Integer pageSize = videoProperties.getLunBoPic();
            int start = 0;
            videoList = videoMapper.getLimitTypeVideoOrderByPlayCount(start, pageSize, null);
        } catch (Exception e) {
            throw new HomeException("视频获取异常");
        }
        return videoList;
    }

    @Override
    public List<String> getAllType() {
        List<String> typeList = null;
        try {
            typeList = typeMapper.getAllType();
        } catch (Exception e) {
            throw new HomeException("获取栏目失败");
        }
        return typeList;
    }
}
