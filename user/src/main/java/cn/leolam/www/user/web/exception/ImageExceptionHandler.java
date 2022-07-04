package cn.leolam.www.user.web.exception;

import cn.leolam.www.user.exception.ImageException;
import cn.leolam.www.user.web.entities.HttpResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
@Slf4j
public class ImageExceptionHandler {
    @ExceptionHandler(value = ImageException.class)
    @ResponseBody
    public HttpResult imageException(Exception e) {
        return HttpResult.fail(400, e.getMessage());
    }
}
