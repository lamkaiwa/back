package cn.leolam.www.video.web.exception.home;

import cn.leolam.www.video.exception.home.HomeException;
import cn.leolam.www.video.web.entities.HttpResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * home异常控制类
 */
@ControllerAdvice
public class HomeExceptionHandler {
    @ExceptionHandler(value = HomeException.class)
    @ResponseBody
    public HttpResult homeException(Exception e) {
        return HttpResult.fail(400, e.getMessage());
    }
}
