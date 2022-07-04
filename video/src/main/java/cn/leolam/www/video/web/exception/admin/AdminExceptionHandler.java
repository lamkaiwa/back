package cn.leolam.www.video.web.exception.admin;

import cn.leolam.www.video.exception.admin.AdminVideoException;
import cn.leolam.www.video.exception.admin.UserException;
import cn.leolam.www.video.web.entities.HttpResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
@ControllerAdvice
public class AdminExceptionHandler {
    @ExceptionHandler(value = UserException.class)
    @ResponseBody
    public HttpResult userException(Exception e) {
        return HttpResult.fail(400, e.getMessage());
    }

    @ExceptionHandler(value = AdminVideoException.class)
    @ResponseBody
    public HttpResult adminVideoException(Exception e){
        return HttpResult.fail(400, e.getMessage());
    }
}
