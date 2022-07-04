package cn.leolam.www.user.web.service.admin;

import cn.leolam.www.user.web.entities.Video;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface AdminVideoService {
    List<Video> getVideosByPage(Integer page, HttpServletRequest request);
    Integer deleteVideoById(Long videoId,HttpServletRequest request);
    Integer getVideosCountByVideoId(HttpServletRequest request);

}
