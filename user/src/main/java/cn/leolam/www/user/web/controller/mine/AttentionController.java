package cn.leolam.www.user.web.controller.mine;

import cn.leolam.www.user.web.entities.Attention;
import cn.leolam.www.user.web.entities.HttpResult;
import cn.leolam.www.user.web.entities.User;
import cn.leolam.www.user.web.service.mine.AttentionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/mine/attention")
public class AttentionController {
    @Autowired
    AttentionService attentionService;

    /**
     * 获取用户的关注列表
     * @param user
     * @return
     */
    @PostMapping("/getAttentionUser")
    @ResponseBody
    public HttpResult getAttentionUser(@RequestBody User user){
        return HttpResult.ok("success",attentionService.getAttentionUser(user));
    }

    /**
     * 取消关注
     * @param attention
     * @return
     */
    @PostMapping("/toggleAtt")
    @ResponseBody
    public HttpResult toggleAtt(@RequestBody Attention attention){
        attentionService.updateAttention(attention);
        return HttpResult.ok("success");
    }
}
