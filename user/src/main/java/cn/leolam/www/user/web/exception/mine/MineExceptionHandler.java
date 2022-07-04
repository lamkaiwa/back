package cn.leolam.www.user.web.exception.mine;

import cn.leolam.www.user.exception.mine.*;
import cn.leolam.www.user.web.entities.HttpResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.File;

@ControllerAdvice
@Slf4j
public class MineExceptionHandler {

    @ExceptionHandler(value = AttentionException.class)
    @ResponseBody
    public HttpResult attentionException(Exception e) {
        return HttpResult.fail(400, e.getMessage());
    }

    @ExceptionHandler(value = CollectionException.class)
    @ResponseBody
    public HttpResult collectionException(Exception e) {
        return HttpResult.fail(400, e.getMessage());
    }

    @ExceptionHandler(value = SetPassWordException.class)
    @ResponseBody
    public HttpResult setPassWordException(Exception e) {
        return HttpResult.fail(400, e.getMessage());
    }

    @ExceptionHandler(value = SettingException.class)
    @ResponseBody
    public HttpResult settingException(SettingException e) {
        String imageFile = e.getImageFile();
        //删除图片
        if (imageFile != null) {
            File file = new File(e.getImageFile());
            if (file.exists()) file.delete();
        }
        return HttpResult.fail(400, e.getMessage());
    }

    @ExceptionHandler(value = VideoException.class)
    @ResponseBody
    public HttpResult videoException(Exception e) {
        return HttpResult.fail(400, e.getMessage());
    }
}
