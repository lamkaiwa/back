package cn.leolam.www.video.web.controller.top;

import cn.leolam.www.video.web.entities.HttpResult;
import cn.leolam.www.video.web.entities.Video;
import cn.leolam.www.video.web.service.top.TopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RequestMapping("/top")
@Controller
public class TopController {
    @Autowired
    TopService topService;
    /**
     * 获取排行榜
     * @return
     */
    @GetMapping("/getTopVideo")
    @ResponseBody
    public HttpResult getTopVideo(HttpServletRequest request){
        List<Video> videoList = topService.getTopVideo(request);
        return HttpResult.ok("success",videoList);
    }
}
