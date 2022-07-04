package cn.leolam.www.video.web.controller.home;

import cn.leolam.www.video.web.entities.HttpResult;
import cn.leolam.www.video.web.entities.Video;
import cn.leolam.www.video.web.service.home.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RequestMapping("/home")
@Controller
public class HomeController {
    @Autowired
    HomeService homeService;
    /**
     * 根据page and type 获取视频信息
     * @param page
     * @param request
     * @param type
     * @return
     */
    @RequestMapping("/getVideoPage")
    @ResponseBody
    public HttpResult getVideoPage(@RequestParam("page") Integer page,
                                   HttpServletRequest request,
                                   @RequestParam(value = "type",required = false) Integer type) {
        List<Video> videoList = homeService.getLimitVideoOrderByPlayCount(page,request,type);
        return HttpResult.ok("success",videoList);
    }
    /**
     * 根据视频的type获取视频的总数
     * @param type
     * @return
     */
    @RequestMapping("/getTotalVideoByType")
    @ResponseBody
    public HttpResult getTotalVideoCountByType(@RequestParam(value = "type",required = false) Integer type){
        return HttpResult.ok("success",homeService.getAllVideoCountByType(type));
    }

    /**
     * 获取视频的轮播图
     * @return
     */
    @GetMapping("/getLunBoPic")
    @ResponseBody
    public HttpResult getLunBoPic(){
        return HttpResult.ok("success",homeService.getLunBoPic());
    }

    /**
     * 获取所有的类别
     * @return
     */
    @GetMapping("/getAllType")
    @ResponseBody
    public HttpResult getAllType(){
        return HttpResult.ok("success",homeService.getAllType());
    }



}
