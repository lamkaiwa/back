package cn.leolam.www.video.web.service.impl;

import cn.leolam.www.video.exception.ImageException;
import cn.leolam.www.video.web.service.ImageService;
import cn.leolam.www.video.web.utils.ImageUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletResponse;

/**
 * 图片服务
 */

@Service
@Slf4j
@Transactional
public class ImageServiceImpl implements ImageService {

    @Autowired
    ImageUtils imageUtils;
    /**
     * 获取视频图片
     * @param type
     * @param imageName
     * @param response
     */
    @Override
    public void getVideoImage(String type,String imageName,HttpServletResponse response) {
        byte[] bytes= null;
        try {
            setImageResponseHeader(response);
            bytes = imageUtils.getAllBytes(type,imageName);
            response.getOutputStream().write(bytes);
            response.getOutputStream().close();
        } catch (Exception e) {
            log.info(e.getMessage());
            throw new ImageException("无法获取图片");
        }
    }

    //设置图片响应头
    private void setImageResponseHeader(HttpServletResponse response){
        response.setHeader("Content-Type","image/jpeg");
        response.setHeader("cache-control", "max-age=12000");
    }
}
