package cn.leolam.www.user.web.exception.admin;

import cn.leolam.www.user.exception.admin.AdminNoticeException;
import cn.leolam.www.user.exception.admin.AdminVideoException;
import cn.leolam.www.user.exception.admin.UserException;
import cn.leolam.www.user.web.entities.HttpResult;
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
    @ExceptionHandler(value = AdminNoticeException.class)
    @ResponseBody
    public HttpResult adminNoticeException(Exception e){
        return HttpResult.fail(400, e.getMessage());
    }
}
