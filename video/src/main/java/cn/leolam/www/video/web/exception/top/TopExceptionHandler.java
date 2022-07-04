package cn.leolam.www.video.web.exception.top;

import cn.leolam.www.video.exception.top.TopException;
import cn.leolam.www.video.web.entities.HttpResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class TopExceptionHandler {
    @ExceptionHandler(value = TopException.class)
    @ResponseBody
    public HttpResult topException(Exception e) {
        return HttpResult.fail(400, e.getMessage());
    }
}
