package cn.leolam.www.video.web.controller.admin;

import cn.leolam.www.video.web.entities.HttpResult;
import cn.leolam.www.video.web.entities.Video;
import cn.leolam.www.video.web.service.admin.AdminVideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RequestMapping("/admin/video")
@Controller
@PreAuthorize("hasAnyAuthority('admin')")
public class AdminVideoController {
    @Autowired
    AdminVideoService adminVideoService;

    /**
     * 删除一个视频
     * @param id
     * @param request
     * @return
     */
    @RequestMapping("/deleteVideo")
    @ResponseBody
    public HttpResult deleteVideo(@RequestParam("videoId") Long id, HttpServletRequest request) {
        adminVideoService.deleteVideoByVideoId(id, request);
        return HttpResult.ok("success");
    }

    /**
     * 编辑视频
     * @param video
     * @return
     */
    @PostMapping("/editVideo")
    @ResponseBody
    public HttpResult editVideo(@RequestBody Video video) {
        adminVideoService.editVideo(video);
        return HttpResult.ok("success");
    }

    /**
     * 视频分类
     * @return
     */
    @GetMapping("/getType")
    @ResponseBody
    public HttpResult getType() {
        return HttpResult.ok("success", adminVideoService.getType());
    }
}
