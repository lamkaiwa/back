package cn.leolam.www.user.web.exception.message;

import cn.leolam.www.user.exception.message.NoticeException;
import cn.leolam.www.user.exception.message.ReplyException;
import cn.leolam.www.user.web.entities.HttpResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
@Slf4j
public class MessageExceptionHandler {
    @ExceptionHandler(value = NoticeException.class)
    @ResponseBody
    public HttpResult noticeException(Exception e) {
        return HttpResult.fail(400, e.getMessage());
    }

    @ExceptionHandler(value = ReplyException.class)
    @ResponseBody
    public HttpResult replyException(Exception e) {
        return HttpResult.ok("success", e.getMessage());
    }
}
