package cn.leolam.www.video.web.service.home;

import cn.leolam.www.video.web.entities.Video;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface HomeService {
    /**
     * 根据视频的page type 获取videoList
     * @param page
     * @param request
     * @param type
     * @return
     */
    List<Video> getLimitVideoOrderByPlayCount(Integer page, HttpServletRequest request, Integer type);

    /**
     * 获取type 下  一共有多少个视频
     * @param type
     * @return
     */
    Integer getAllVideoCountByType(Integer type);

    /**
     * 获取轮播图的video
     * @return
     */
    List<Video> getLunBoPic();

    /**
     * 获取分类列表
     * @return
     */
    List<String> getAllType();
}
