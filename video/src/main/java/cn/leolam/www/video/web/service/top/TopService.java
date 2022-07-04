package cn.leolam.www.video.web.service.top;

import cn.leolam.www.video.web.entities.Video;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface TopService {
    /**
     * 最多人看的video
     * @param request
     * @return
     */
    List<Video> getTopVideo(HttpServletRequest request);
}
