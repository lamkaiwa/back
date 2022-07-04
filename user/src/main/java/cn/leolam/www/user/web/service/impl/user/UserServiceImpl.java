package cn.leolam.www.user.web.service.impl.user;

import cn.leolam.www.user.exception.user.UserException;
import cn.leolam.www.user.web.entities.Attention;
import cn.leolam.www.user.web.entities.Video;
import cn.leolam.www.user.web.mapper.AttentionMapper;
import cn.leolam.www.user.web.service.user.UserService;
import cn.leolam.www.user.web.utils.RestTemplateUtils;
import com.alibaba.fastjson.JSONArray;
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
public class UserServiceImpl implements UserService {
    @Autowired
    AttentionMapper attentionMapper;

    @Autowired
    RestTemplateUtils restTemplateUtils;

    @Override
    public Boolean isAttention(Attention attention) {
        Boolean b = true;
        try {
            Integer i = attentionMapper.getAttentionExistByUserIdAndFans(attention);
            if (i != 1) {
                b = false;
            }
        } catch (Exception e) {
            throw new UserException("获取关注李彪失败");
        }
        return b;
    }

    @Override
    public void cancelAttention(Attention attention) {
        try {
            Integer i = attentionMapper.deleteAttentionByUserIdAndFans(attention);
            if (i != 1) {
                throw new UserException("取消失败");
            }
        } catch (Exception e) {
            log.info(e.getMessage());
            throw new UserException("取消失败");
        }
    }

    @Override
    public void addAttention(Attention attention) {
        try {
            Integer i = attentionMapper.insertAttentionByByUserIdAndFans(attention);
            if (i != 1) {
                throw new UserException("添加失败");
            }
        } catch (Exception e) {
            log.info(e.getMessage());
            throw new UserException("添加失败");
        }
    }

    @Override
    public List<Video> getSearchVideoByLikeSortTypeUserId(Integer page, String words, String sortBy, Integer userId, HttpServletRequest request) {
        List<Video> videoList = null;
        try {
            HttpHeaders headers = new HttpHeaders();
            MultiValueMap<String, Object> params = new LinkedMultiValueMap<>();
            headers.add("Authorization", request.getHeader("Authorization"));
            params.add("words", words);
            params.add("page", String.valueOf(page));
            params.add("sortBy", sortBy);
            params.add("userId", String.valueOf(userId));
            ResponseEntity<Map> responseEntity = restTemplateUtils.sendToAuthGetUserToken("/video/mine/video/getVideoPageByUser", headers, params);
            Map<String, String> map = responseEntity.getBody();
            String json = JSONObject.toJSONString(map.get("data"));
            videoList = JSONArray.parseArray(json, Video.class);
        } catch (Exception e) {
            log.info(e.getMessage());
            throw new UserException("视频获取失败");
        }
        return videoList;
    }


    @Override
    public Integer getSearchVideoCountByLikeUserId(String words, Integer userId,HttpServletRequest request) {
        Integer count = null;
        try {
            HttpHeaders headers = new HttpHeaders();
            MultiValueMap<String, Object> params = new LinkedMultiValueMap<>();
            headers.add("Authorization", request.getHeader("Authorization"));
            params.add("words", words);
            params.add("userId", String.valueOf(userId));
            ResponseEntity<Map> responseEntity = restTemplateUtils.sendToAuthGetUserToken("/video/mine/video/searchCount", headers, params);
            Map<String, Object> map = responseEntity.getBody();
            count=(Integer)map.get("data");
        } catch (Exception e) {
            log.info(e.getMessage());
            throw new UserException("获取视频总数失败");
        }
        return count;
    }
}
