package cn.leolam.www.video.web.exception.mine;

import cn.leolam.www.video.exception.mine.VideoException;
import cn.leolam.www.video.web.entities.HttpResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class VideoExceptionHandler {
    @ExceptionHandler(value = VideoException.class)
    @ResponseBody
    public HttpResult videoException(Exception e) {
        return HttpResult.fail(400, e.getMessage());
    }
}
