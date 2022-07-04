package cn.leolam.www.video.web.exception;

import cn.leolam.www.video.exception.ImageException;
import cn.leolam.www.video.web.entities.HttpResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 图片分类异常类
 */
@ControllerAdvice
public class ImageExceptionHandler {
    @ExceptionHandler(value = ImageException.class)
    @ResponseBody
    public HttpResult ImageException(Exception e) {
        return HttpResult.fail(400, e.getMessage());
    }

}
