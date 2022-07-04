package cn.leolam.www.user.web.service.impl.admin;

import cn.leolam.www.user.exception.admin.AdminVideoException;
import cn.leolam.www.user.web.entities.Comment;
import cn.leolam.www.user.web.entities.Video;
import cn.leolam.www.user.web.mapper.CommentMapper;
import cn.leolam.www.user.web.mapper.MessageMapper;
import cn.leolam.www.user.web.mapper.ReplyMapper;
import cn.leolam.www.user.web.service.admin.AdminVideoService;
import cn.leolam.www.user.web.utils.RestTemplateUtils;
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
 * 重置服务
 */
@Service
@Slf4j
@Transactional
public class AdminVideoServiceImpl implements AdminVideoService {
    @Autowired
    RestTemplateUtils restTemplateUtils;

    @Autowired
    CommentMapper commentMapper;

    @Autowired
    ReplyMapper replyMapper;

    @Autowired
    MessageMapper messageMapper;

    @Override
    public List<Video> getVideosByPage(Integer page, HttpServletRequest request) {
        List<Video> videoList = null;
        try {
            HttpHeaders headers = new HttpHeaders();
            MultiValueMap<String, Object> params = new LinkedMultiValueMap<>();
            headers.add("Authorization", request.getHeader("Authorization"));
            params.add("page", page);
            params.add("type", null);
            ResponseEntity<Map> responseEntity = restTemplateUtils.sendToAuthGetUserToken("/video/home/getVideoPage", headers, params);
            Map<String, String> map = responseEntity.getBody();
            String json = JSONObject.toJSONString(map.get("data"));
            videoList = JSONObject.parseArray(json, Video.class);
        } catch (Exception e) {
            log.info(e.getMessage());
            throw new AdminVideoException("获取视频列表失败");
        }
        return videoList;
    }

    @Override
    public Integer deleteVideoById(Long videoId, HttpServletRequest request) {
        try {
            List<Comment> commentList = commentMapper.getCommentsByVideoId(Integer.parseInt(String.valueOf(videoId)));
            for (Comment comment :
                    commentList) {
                replyMapper.deleteReplysByCommentId(comment.getId());
                messageMapper.deleteMessagesByCommentId(comment.getId());
            }
            HttpHeaders headers = new HttpHeaders();
            MultiValueMap<String, Object> params = new LinkedMultiValueMap<>();
            params.add("videoId", videoId);
            headers.add("Authorization", request.getHeader("Authorization"));
            ResponseEntity<Map> responseEntity = restTemplateUtils.sendToAuthGetUserToken("/video/admin/video/deleteVideo", headers, params);
            Map<String, Object> map = responseEntity.getBody();
            if (!((Integer) map.get("code") == 200)) {
                throw new Exception();
            }
        } catch (Exception e) {
            log.info(e.getMessage());
            throw new AdminVideoException("删除一个视频失败");
        }
        return 1;
    }

    @Override
    public Integer getVideosCountByVideoId(HttpServletRequest request) {
        Integer res = null;
        try {
            HttpHeaders headers = new HttpHeaders();
            MultiValueMap<String, Object> params = new LinkedMultiValueMap<>();
            params.add("type", null);
            headers.add("Authorization", request.getHeader("Authorization"));
            ResponseEntity<Map> responseEntity = restTemplateUtils.sendToAuthGetUserToken("/video/home/getTotalVideoByType", headers, params);
            Map<String, Object> map = responseEntity.getBody();
            if (!((Integer) map.get("code") == 200)) {
                throw new Exception();
            }
            res = (Integer) map.get("data");
        } catch (Exception e) {
            log.info(e.getMessage());
            throw new AdminVideoException("获取视频总数失败");
        }
        return res;
    }
}
