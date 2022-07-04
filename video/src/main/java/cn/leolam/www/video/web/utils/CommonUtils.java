package cn.leolam.www.video.web.utils;

import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class CommonUtils {
    static String root = "/tmp/tv/";
    //图片后缀
    String dirName=null;
    //文件目录
    String suffix=null;

    public CommonUtils(String dirName, String suffix) {
        this.dirName = dirName;
        this.suffix = suffix;
    }
    /**
     * 文件路径
     *
     * @return
     * @throws Exception
     */
    public  String getFilePath(String category, String fileName) throws Exception {
        String path = root;
        String filePath = path + dirName + "/" + category + "/" + fileName + suffix;
        return filePath;
    }

    /**
     * 删除一张图片
     *
     * @throws Exception
     */
    public  void deleteFile(String dir, String FileName) throws Exception {
        String imageFilePath = getFilePath(dir, FileName);
        File file = new File(imageFilePath);
        if (file.exists()) file.delete();
    }

    /**
     * 获取资源bytes
     *
     * @return
     * @throws Exception
     */
    public  byte[] getAllBytes(String category, String videoName) throws Exception {
        String path = getFilePath(category, videoName);
        InputStream inputStream = new FileInputStream(path);
        int size = inputStream.available();
        byte[] bytes = new byte[size];
        inputStream.read(bytes);
        inputStream.close();
        return bytes;
    }

    public  String getDirPath(String dir)throws Exception{
        String path = root;
        String dirPath = path + dirName + "/" + dir;

        return dirPath;
    }

    /**
     * 创建File
     *
     * @param fileName
     * @return
     * @throws Exception
     */
    public  void createDownLoadFile(String dir, String fileName) throws Exception {
        String filePath = getFilePath(dir, fileName);
        String fileDir=getDirPath(dir);
        File dirFile=new File(fileDir);
        //创建dir
        if(!dirFile.isDirectory()){
            dirFile.mkdirs();
        }
        //创建file
        File file = new File(filePath);
        if (!file.exists()) file.createNewFile();
        return;
    }

}
