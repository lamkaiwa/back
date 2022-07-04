package cn.leolam.www.user.exception.mine;

public class SettingException extends RuntimeException{
    String imageFile;
    public SettingException(String message,String imageFile) {
        super(message);
        this.imageFile=imageFile;
    }
    public String getImageFile() {
        return imageFile;
    }
}
