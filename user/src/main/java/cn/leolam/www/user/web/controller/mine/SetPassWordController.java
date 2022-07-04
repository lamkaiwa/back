package cn.leolam.www.user.web.controller.mine;

import cn.leolam.www.user.web.entities.HttpResult;
import cn.leolam.www.user.web.entities.User;
import cn.leolam.www.user.web.service.login.ResetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/mine/setPassWord")
public class SetPassWordController {
    @Autowired
    ResetService resetService;

    @PostMapping("/updatePassWord")
    @ResponseBody
    public HttpResult updatePassWord(@RequestBody User user){
        resetService.updatePass(user);
        return HttpResult.ok("success");
    }
}
