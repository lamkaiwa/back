package cn.leolam.www.user.web.exception.login;

import cn.leolam.www.user.exception.login.LoginFormException;
import cn.leolam.www.user.exception.login.ReSetException;
import cn.leolam.www.user.exception.login.SignInException;
import cn.leolam.www.user.web.entities.HttpResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
@Slf4j
public class LoginExceptionHandler {

    @ExceptionHandler(value = LoginFormException.class)
    @ResponseBody
    public HttpResult loginFormException(Exception e) {
        return HttpResult.fail(400, e.getMessage());
    }

    @ExceptionHandler(value = SignInException.class)
    @ResponseBody
    public HttpResult signInException(Exception e){
        return HttpResult.fail(400, e.getMessage());
    }

    @ExceptionHandler(value = ReSetException.class)
    @ResponseBody
    public HttpResult reSetException(Exception e){
        return HttpResult.fail(400, e.getMessage());
    }


}
