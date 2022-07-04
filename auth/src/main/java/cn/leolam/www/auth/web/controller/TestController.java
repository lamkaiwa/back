package cn.leolam.www.auth.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class TestController {
    @RequestMapping("t2")
    @ResponseBody
    public String test2(HttpServletRequest request){
        System.out.println(request.getSession().getAttribute("name"));
        return "leolam";
    }
}
