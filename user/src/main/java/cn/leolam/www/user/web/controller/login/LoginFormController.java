package cn.leolam.www.user.web.controller.login;

import cn.leolam.www.user.web.entities.HttpResult;
import cn.leolam.www.user.web.entities.User;
import cn.leolam.www.user.web.service.login.LoginFormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 登入
 */
@RequestMapping("/login/loginForm")
@Controller
public class LoginFormController {
    @Autowired
    LoginFormService loginFormService;
    /**
     * 登入
     * @param user
     * @return
     */
    @PostMapping("/login")
    @ResponseBody
    public HttpResult login(@RequestBody User user){
        User userInfo=loginFormService.login(user);
        return HttpResult.ok(userInfo);
    }
}
