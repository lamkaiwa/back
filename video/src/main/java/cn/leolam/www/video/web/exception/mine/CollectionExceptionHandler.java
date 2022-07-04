package cn.leolam.www.video.web.exception.mine;

import cn.leolam.www.video.exception.mine.CollectionException;
import cn.leolam.www.video.web.entities.HttpResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class CollectionExceptionHandler {
    @ExceptionHandler(value = CollectionException.class)
    @ResponseBody
    public HttpResult collectionException(Exception e) {
        return HttpResult.fail(400, e.getMessage());
    }
}
