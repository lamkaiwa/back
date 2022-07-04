package cn.leolam.www.user.web.exception.user;

import cn.leolam.www.user.exception.user.UserException;
import cn.leolam.www.user.web.entities.HttpResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
@Slf4j
public class UserExceptionHandler {
    @ExceptionHandler(value = UserException.class)
    @ResponseBody
    public HttpResult userException(Exception e) {
        log.info(e.getMessage());
        return HttpResult.fail(400, e.getMessage());
    }
}
