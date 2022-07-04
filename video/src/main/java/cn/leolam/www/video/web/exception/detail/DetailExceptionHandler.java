package cn.leolam.www.video.web.exception.detail;

import cn.leolam.www.video.exception.detail.DetailException;
import cn.leolam.www.video.web.entities.HttpResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
@ControllerAdvice
public class DetailExceptionHandler {
    @ExceptionHandler(value = DetailException.class)
    @ResponseBody
    public HttpResult detailException(Exception e) {
        return HttpResult.fail(400, e.getMessage());
    }
}
