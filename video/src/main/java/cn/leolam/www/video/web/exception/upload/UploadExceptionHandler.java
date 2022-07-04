package cn.leolam.www.video.web.exception.upload;

import cn.leolam.www.video.exception.upload.UploadException;
import cn.leolam.www.video.web.entities.HttpResult;
import cn.leolam.www.video.web.utils.ImageUtils;
import cn.leolam.www.video.web.utils.VideoUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 上传异常类
 */
@ControllerAdvice
@Slf4j
public class UploadExceptionHandler {
    @Autowired
    ImageUtils imageUtils;

    @Autowired
    VideoUtils videoUtils;


    @ExceptionHandler(value = UploadException.class)
    @ResponseBody
    public HttpResult UploadException(UploadException e) {
        if (e.getFileName() != null && e.getDir() != null) {
            try {
                imageUtils.deleteFile(e.getDir(),e.getFileName());
                videoUtils.deleteFile(e.getDir(),e.getFileName());
            }catch (Exception exception){
                log.info(exception.getMessage());
            }
        }
        return HttpResult.fail(400, e.getMessage());
    }
}
