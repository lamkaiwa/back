package cn.leolam.www.user.web.controller.admin;

import cn.leolam.www.user.web.entities.HttpResult;
import cn.leolam.www.user.web.entities.Notice;
import cn.leolam.www.user.web.service.admin.AdminNoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/admin/notice")
@Controller
@PreAuthorize("hasAnyAuthority('admin')")
public class AdminNoticeController {
    @Autowired
    AdminNoticeService adminNoticeService;

    /**
     * 新增notice
     * @param notice
     * @return
     */
    @PostMapping("/insertNotice")
    @ResponseBody
    public HttpResult insertNotice(@RequestBody Notice notice) {
        return HttpResult.ok("success", adminNoticeService.insertNoticeByNotice(notice));
    }

    /**
     * notice 数量
     * @return
     */
    @GetMapping("/getNoticeCount")
    @ResponseBody
    public HttpResult getNoticeCount() {
        return HttpResult.ok("success", adminNoticeService.getNoticesCount());
    }

    /**
     * 删除notice
     * @param id
     * @return
     */
    @GetMapping("/deleteNotice")
    @ResponseBody
    public HttpResult deleteNotice(@RequestParam("id") Integer id) {
        return HttpResult.ok("success", adminNoticeService.deleteNoticeById(id));
    }

    /**
     * 获取所有的notice
     * @param page
     * @return
     */
    @GetMapping("/getNotices")
    @ResponseBody
    public HttpResult getNotices(@RequestParam("page") Integer page) {
        return HttpResult.ok("success", adminNoticeService.getNoticeByPage(page));
    }

    /**
     * 更新notice
     * @param notice
     * @return
     */
    @PostMapping("/updateNotice")
    @ResponseBody
    public HttpResult updateNotice(@RequestBody Notice notice){
        return HttpResult.ok("success",adminNoticeService.updateNoticeByNotice(notice));
    }
}
