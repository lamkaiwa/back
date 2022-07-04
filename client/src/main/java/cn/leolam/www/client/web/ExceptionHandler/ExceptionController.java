package cn.leolam.www.client.web.ExceptionHandler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * http状态码处理
 * 登录失败处理
 */
@Controller
public class ExceptionController {
    /**
     * 404
     * @param request
     * @return
     */
    @RequestMapping(value = "/notFound")
    public String error404(HttpServletRequest request){
        request.setAttribute("message","兄弟当前页面不存在，请点击下面按钮回到首页");
        return "404";
    }

}
