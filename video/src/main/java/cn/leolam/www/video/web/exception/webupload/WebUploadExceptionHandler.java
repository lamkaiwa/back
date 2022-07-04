package cn.leolam.www.video.web.exception.webupload;

import cn.leolam.www.video.exception.webupload.WebUploadException;
import cn.leolam.www.video.web.entities.HttpResult;
import cn.leolam.www.video.web.utils.VideoUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class WebUploadExceptionHandler {
    @Autowired
    VideoUtils videoUtils;

    @ExceptionHandler(value = WebUploadException.class)
    @ResponseBody
    public HttpResult webUploadException(WebUploadException e) {
        return HttpResult.fail(400, e.getMessage());
    }
}
