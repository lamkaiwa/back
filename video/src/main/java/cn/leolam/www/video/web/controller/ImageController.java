package cn.leolam.www.video.web.controller;

import cn.leolam.www.video.web.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;

/**
 * 图片控制层
 */
@Controller
@RequestMapping("/imageController")
public class ImageController {
    @Autowired
    ImageService imageService;

    /**
     * 获取视频封面图片
     * @param response
     * @param type
     * @param imageName
     */
    @GetMapping("/getVideoImage/{type}/{imageName}")
    public void getVideoImage(HttpServletResponse response,@PathVariable("type") String type,@PathVariable("imageName") String imageName){
        imageService.getVideoImage(type,imageName,response);
    }



}
