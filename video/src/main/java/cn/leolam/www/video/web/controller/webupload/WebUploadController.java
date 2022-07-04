package cn.leolam.www.video.web.controller.webupload;

import cn.leolam.www.video.web.entities.HttpResult;
import cn.leolam.www.video.web.entities.YoutubeDL;
import cn.leolam.www.video.web.service.webupload.WebUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/webUpload")
public class WebUploadController {
    @Autowired
    WebUploadService webUploadService;

    /**
     * 获取能下载的资源信息
     *
     * @param url
     * @return
     */
    @GetMapping("/getYoutubeDLsByUrl")
    @ResponseBody
    public HttpResult getYoutubeDLsByUrl(@RequestParam("url") String url) {
        List<YoutubeDL> youtubeDLList = webUploadService.getYoutubeDLsByUrl(url);
        return HttpResult.ok("success", youtubeDLList);
    }

    /**
     * 下载web video
     *
     * @param map
     * @return
     */
    @PostMapping("/downLoadVideoByYoutubeDl")
    @ResponseBody
    public HttpResult downLoadVideoByYoutubeDl(@RequestBody Map<String, String> map) {
        //开启一个线程执行，任务
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                webUploadService.downLoadVideoByYoutubeDl(map);
            }
        });
        thread.start();
        return HttpResult.ok("success");
    }
}
