package cn.leolam.www.user.web.controller.login;

import cn.leolam.www.user.web.entities.HttpResult;
import cn.leolam.www.user.web.entities.User;
import cn.leolam.www.user.web.service.login.SignInService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/login/signIn")
@Controller
public class SignInController {

    @Autowired
    SignInService signInService;

    /**
     * 注册
     * @param user
     * @return
     */
    @PostMapping("/reg")
    @ResponseBody
    public HttpResult reg(@RequestBody User user){
        signInService.reg(user);
        return HttpResult.ok("success");
    }
}
