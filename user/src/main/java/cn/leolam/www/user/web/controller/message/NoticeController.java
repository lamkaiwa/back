package cn.leolam.www.user.web.controller.message;

import cn.leolam.www.user.web.entities.HttpResult;
import cn.leolam.www.user.web.service.message.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 系统信息
 */
@RequestMapping("/message/notice")
@Controller
public class NoticeController {
    @Autowired
    NoticeService noticeService;

    /**
     * 获取系统通知
     * @return
     */
    @GetMapping("/getNotices")
    @ResponseBody
    public HttpResult getNotices(){
        return HttpResult.ok("success",noticeService.getNotices());
    }
}
