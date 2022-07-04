package cn.leolam.www.video.web.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * mp4box
 */
@Component
public class Mp4BoxUtils {
    @Autowired
    VideoUtils videoUtils;
    //exe name
    static String Mp4Box = "MP4Box";

    //分片时间
    static String TIME = "60000";

    /**
     * 创建dash_mp4
     * @param fileName
     * @param dir
     * @throws Exception
     */
    public void createDashMp4(String dir, String fileName) throws Exception {
        String videoDir = videoUtils.getDirPath(dir);
        String videoName = fileName + VideoUtils.suffix;
        runCommandCreateDashMp4(videoDir, videoName, TIME);
    }

    /**
     * 运行cmd创建mp4 dash
     * @param videoDir
     * @param videoName
     * @param time
     * @throws Exception
     */
    public void runCommandCreateDashMp4(String videoDir, String videoName, String time) throws Exception {
        String linuxCmd = "cd " + videoDir + " " + "&& " + Mp4Box + " " + "-dash " + time + " " + "-frag " + time + " " + videoName;
        String[] cmd = new String[]{"sh", "-c", linuxCmd};
        Process process = Runtime.getRuntime().exec(cmd);
        process.waitFor();
        process.destroy();
    }
}
