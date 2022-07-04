package cn.leolam.www.video.web.utils;


import org.springframework.stereotype.Component;

import java.io.File;

@Component
public class ImageUtils extends CommonUtils {
    //图片后缀
   static String dir="image";
    //文件目录
   static String suffix=".jpg";

    public ImageUtils() {
        super(dir, suffix);
    }

    public void createDir(String dir) throws Exception{
        String dirPath = this.getDirPath(dir);
        File file = new File(dirPath);
        //创建dir
        if(!file.isDirectory()){
            file.mkdirs();
        }
    }
}
