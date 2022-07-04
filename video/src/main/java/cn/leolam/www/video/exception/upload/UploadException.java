package cn.leolam.www.video.exception.upload;

import lombok.Data;

@Data
public class UploadException extends RuntimeException {
    String dir = null;
    String fileName = null;

    public UploadException(String message, String dir, String fileName) {
        super(message);
        this.dir = dir;
        this.fileName = fileName;
    }

}
