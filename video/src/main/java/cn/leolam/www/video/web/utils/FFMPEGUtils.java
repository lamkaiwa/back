package cn.leolam.www.video.web.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
@Slf4j
public class FFMPEGUtils {


    //exe name
    static String FFMPEG = "ffmpeg";
    //缩图大小
    static String GetImageBytesOnSpecifiedTimeSize = "200*200";
    //缩图后缀
    static String GetImageBytesOnSpecifiedTimeSizeSuSUFFIX = ".jpg";

    //缩图大小
    static String GetImageBytesOnFirstTimeSize = "250*250";

    @Autowired
    VideoUtils videoUtils;
    @Autowired
    ImageUtils imageUtils;

    /**
     * 获取指定时间视频的图片
     *
     * @param dir
     * @param fileName
     * @param time
     * @return
     * @throws Exception
     */
    public byte[] getImageBytesOnSpecifiedTime(String dir, String fileName, String time) throws Exception {
        //MP4
        String videoFile = videoUtils.getVideoDashPath(dir, fileName);
        //outputfile
        String targetDir = videoUtils.getDirPath(dir);
        String uuid = UUID.randomUUID().toString();
        String targetFile = targetDir + "/" + fileName + uuid + GetImageBytesOnSpecifiedTimeSizeSuSUFFIX;
        runCommandForGetImageBytesOnSpecifiedTime(videoFile, targetFile, time, GetImageBytesOnSpecifiedTimeSize);
        File file = new File(targetFile);
        InputStream inputStream = new FileInputStream(file);
        int size = inputStream.available();
        byte[] bytes = new byte[size];
        inputStream.read(bytes);
        inputStream.close();
        //删除目标文件
        file.delete();
        return bytes;
    }

    /**
     * FFMPEG执行指令for GetImageBytesOnSpecifiedTime
     *
     * @param videoFile
     * @param outputTargetFile
     * @param time
     * @throws Exception
     */
    private void runCommandForGetImageBytesOnSpecifiedTime(String videoFile, String outputTargetFile, String time, String size) throws Exception {
        List<String> list = new ArrayList<>();
        list.add(FFMPEG);
        list.add("-ss");
        list.add(time);
        list.add("-i");
        list.add(videoFile);
        list.add("-r");
        list.add("1");
        list.add("-vframes");
        list.add("1");
        list.add("-an");
        list.add("-vcodec");
        list.add("mjpeg");
        list.add("-s");
        list.add(size);
        list.add(outputTargetFile);
        ProcessBuilder BUILD = new ProcessBuilder();
        BUILD.command(list);
        Process p = BUILD.start();
        p.waitFor();
        p.destroy();
    }

    /**
     * 获取视频的第一帧图片
     *
     * @param dir
     * @param fileName
     * @param time
     * @return
     * @throws Exception
     */

    public void getImagePicOnFirstTime(String dir, String fileName, String time) throws Exception {
        imageUtils.createDir(dir);
        //image
        String imagePath = imageUtils.getFilePath(dir, fileName);
        log.info(imagePath);
        //videoFile
        String videoFile = videoUtils.getVideoDashPath(dir, fileName);
        //截取第一帧图片
        runCommandForGetImageBytesOnSpecifiedTime(videoFile, imagePath, time, GetImageBytesOnFirstTimeSize);
    }
}
