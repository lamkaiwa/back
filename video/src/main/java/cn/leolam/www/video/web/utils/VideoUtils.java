package cn.leolam.www.video.web.utils;


import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

@Component
public class VideoUtils extends CommonUtils {

    static String dir = "video";
    static String suffix = ".mp4";
    String append = "_dashinit";

    public VideoUtils() {
        super(dir, suffix);
    }

    public void deleteVideoDashFile(String dir, String fileName)throws Exception{
        String filePath = getVideoDashPath(dir,fileName);
        File file = new File(filePath);
        if (file.exists()) file.delete();
    }
    /**
     * 获取Video dash路径
     *
     * @param dir
     * @param fileName
     * @return
     * @throws Exception
     */
    public String getVideoDashPath(String dir, String fileName) throws Exception {
        String dirPath = getDirPath(dir);
        return dirPath + "/" + fileName + append + suffix;
    }

    /**
     * 获取视频的全部byte
     * @param dir
     * @param fileName
     * @return
     * @throws Exception
     */
    public byte[] getVideoBytes(String dir, String fileName) throws Exception {
        String videoPath = getVideoDashPath(dir, fileName);
        File file=new File(videoPath);
        byte[] bytes= FileUtils.readFileToByteArray(file);
        return bytes;
    }

    /**
     * 按照start end 截取video
     *
     * @param category
     * @param nameOfVideo
     * @param start
     * @param end
     * @return
     */
    public byte[] videoUtilVideoClipToBytes(String category, String nameOfVideo, int start, int end) throws Exception {
        String videoPath = getVideoDashPath(category, nameOfVideo);
        byte[] videoByte = new byte[end - start];
        try {
            FileInputStream fileInputStream = new FileInputStream(videoPath);
            fileInputStream.skip(start);
            fileInputStream.read(videoByte);
            fileInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return videoByte;
    }

}
