package cn.leolam.www.video.web.exception.search;

import cn.leolam.www.video.exception.search.SearchException;
import cn.leolam.www.video.web.entities.HttpResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
@ControllerAdvice
public class SearchExceptionHandler {
    @ExceptionHandler(value = SearchException.class)
    @ResponseBody
    public HttpResult searchException(Exception e) {
        return HttpResult.fail(400, e.getMessage());
    }
}
