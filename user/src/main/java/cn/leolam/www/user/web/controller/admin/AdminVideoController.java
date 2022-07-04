package cn.leolam.www.user.web.controller.admin;

import cn.leolam.www.user.web.entities.HttpResult;
import cn.leolam.www.user.web.service.admin.AdminVideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@RequestMapping("/admin/video")
@Controller
@PreAuthorize("hasAnyAuthority('admin')")
public class AdminVideoController {
    @Autowired
    AdminVideoService adminVideoService;

    /**
     * 获取视频列表根据page
     * @param page
     * @param request
     * @return
     */
    @GetMapping("/getVideosByPage")
    @ResponseBody
    public HttpResult getVideosByPage(@RequestParam("page") Integer page, HttpServletRequest request) {
        return HttpResult.ok("success", adminVideoService.getVideosByPage(page, request));
    }

    /**
     * 删除视频
     * @param videoId
     * @param request
     * @return
     */
    @RequestMapping("/deleteVideo")
    @ResponseBody
    public HttpResult deleteVideo(@RequestParam("videoId") Long videoId, HttpServletRequest request) {
        adminVideoService.deleteVideoById(videoId, request);
        return HttpResult.ok("success");
    }

    /**
     * 获取视频的总数
     * @param request
     * @return
     */
    @RequestMapping("/getVideosCount")
    @ResponseBody
    public HttpResult getVideosCount(HttpServletRequest request) {
        return HttpResult.ok("success", adminVideoService.getVideosCountByVideoId(request));
    }

}
