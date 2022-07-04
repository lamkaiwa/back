package cn.leolam.www.user.web.utils;



import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class ImageUtils {
    static String root = "/tmp/tv/";
    static String VideoDirName="avatar";

    //图片后缀
    public static String SUFFIX=".jpg";

    /**
     * 图片文件路径
     * @param name
     * @return
     * @throws Exception
     */
    public static String GetImageFilePath(String name)throws Exception{
        String appPath= root;
        File file=new File(appPath+VideoDirName);
        //创建dir
        if(!file.isDirectory()){
            file.mkdirs();
        }
        String imagePath=appPath+VideoDirName+"/"+name+SUFFIX;
        return imagePath;
    }

    /**
     * 获取图片dir路径
     * @return
     * @throws Exception
     */
    public static String GetImageDirPath()throws Exception{
        String appPath= root;
        return appPath+VideoDirName;
    }

    /**
     * 删除一张图片
     * @param name
     * @throws Exception
     */
    public static void deleteImageFile(String name) throws Exception{
        File file=new File(GetImageFilePath(name));
        if(file.exists()) file.delete();
    }




    /**
     * 图片资源bytes
     * @param imageFileName
     * @return
     * @throws Exception
     */
    public static byte[] GetImageAllBytes(String imageFileName)throws Exception {
        String imagePath=GetImageFilePath(imageFileName);
        InputStream inputStream=new FileInputStream(imagePath);
        int size=inputStream.available();
        byte[] bytes=new byte[size];
        inputStream.read(bytes);
        inputStream.close();
        return bytes;
    }
}
