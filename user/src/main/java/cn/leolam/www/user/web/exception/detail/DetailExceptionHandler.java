package cn.leolam.www.user.web.exception.detail;

import cn.leolam.www.user.exception.detail.DetailException;
import cn.leolam.www.user.web.entities.HttpResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

public class DetailExceptionHandler {
    @ExceptionHandler(value = DetailException.class)
    @ResponseBody
    public HttpResult detailException(Exception e) {
        return HttpResult.fail(400, e.getMessage());
    }
}
