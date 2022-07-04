package cn.leolam.www.user.web.controller.login;

import cn.leolam.www.user.web.entities.HttpResult;
import cn.leolam.www.user.web.entities.User;
import cn.leolam.www.user.web.service.login.ResetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 重置
 */
@RequestMapping("/login/reSet")
@Controller
public class ReSetController {
    @Autowired
    ResetService resetService;
    /**
     * 获取验证码
     * @param user
     * @return
     */
    @PostMapping("/getCode")
    @ResponseBody
    public HttpResult getCode(@RequestBody User user){
        resetService.getCode(user);
        return HttpResult.ok("验证码已经发送到邮箱");
    }
    /**
     * 更新密码
     * @param user
     * @return
     */
    @PostMapping("/updatePass")
    @ResponseBody
    public HttpResult updatePass(@RequestBody User user){
        resetService.updatePass(user);
        return HttpResult.ok("success");
    }
}
