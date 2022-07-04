package cn.leolam.www.video.web.service;

import javax.servlet.http.HttpServletResponse;

/**
 * 图片服务
 */
public interface ImageService {
    /**
     * 获取video pic
     * @param name
     * @param type
     * @param response
     */
    void getVideoImage(String name,String type, HttpServletResponse response);
}
