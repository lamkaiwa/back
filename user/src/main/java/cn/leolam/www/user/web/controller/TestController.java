package cn.leolam.www.user.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {
    @GetMapping("/t1")
    @ResponseBody
    public String p1(){
        return "leolam";
    }
}
