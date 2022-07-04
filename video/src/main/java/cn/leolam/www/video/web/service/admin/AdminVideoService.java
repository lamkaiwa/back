package cn.leolam.www.video.web.service.admin;

import cn.leolam.www.video.web.entities.Video;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface AdminVideoService {
    Integer deleteVideoByVideoId(Long id, HttpServletRequest request);
    Integer editVideo(Video video);
    List<String> getType();
}
