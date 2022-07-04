package cn.leolam.www.user.web.controller;

import cn.leolam.www.user.exception.ImageException;
import cn.leolam.www.user.web.utils.ImageUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/imageController")
public class ImageController {
    @GetMapping("/getAvatar/{name}")
    public void getAvatar(HttpServletResponse response,@PathVariable String name){
        setImageResponseHeader(response);
        byte[] bytes= new byte[0];
        try {
            bytes = ImageUtils.GetImageAllBytes(name);
            response.getOutputStream().write(bytes);
            response.getOutputStream().close();
        } catch (Exception e) {
            throw new ImageException("无法获取图片");
        }
    }
    //设置图片响应头
    private void setImageResponseHeader(HttpServletResponse response){
        response.setHeader("Content-Type","image/jpeg");
        response.setHeader("cache-control", "max-age=12000");
    }
}
