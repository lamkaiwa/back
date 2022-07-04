package cn.leolam.www.video.exception.webupload;

public class WebUploadException extends RuntimeException {
    String fileName;
    String dir;

    public WebUploadException(String message, String fileName, String dir) {
        super(message);
        this.fileName = fileName;
        this.dir = dir;
    }

    public String getFileName() {
        return this.fileName;
    }
    public String getDir() {
        return this.dir;
    }
}
