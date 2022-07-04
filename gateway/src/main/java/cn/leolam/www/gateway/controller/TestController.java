package cn.leolam.www.gateway.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {
    @RequestMapping("/t1")
    @ResponseBody
    public String t1(){
        return "leolam";
    }
}
