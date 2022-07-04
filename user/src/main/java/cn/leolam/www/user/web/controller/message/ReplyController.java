package cn.leolam.www.user.web.controller.message;

import cn.leolam.www.user.web.entities.HttpResult;
import cn.leolam.www.user.web.service.message.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 用户回复
 */
@RequestMapping("/message/reply")
@Controller
public class ReplyController {
    @Autowired
    ReplyService replyService;

    /**
     * 获取用户回复信息
     * @param userId
     * @return
     */
    @GetMapping("/getMessages")
    @ResponseBody
    public HttpResult getMessages(@RequestParam("userId") Long userId){
        return HttpResult.ok("success",replyService.getMessages(userId));
    }

    /**
     * 删除一条message
     * @param id
     * @return
     */
    @GetMapping("/deleteMessage")
    @ResponseBody
    public HttpResult deleteMessage(@RequestParam("id") Long id){
        return HttpResult.ok("success",replyService.deleteMessage(id));
    }
}
