package cn.leolam.www.video.web.utils;

import cn.leolam.www.video.properties.VideoProperties;
import cn.leolam.www.video.web.entities.YoutubeDL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Component
public class YoutubeDlUtils extends CommonUtils {
    //exe name
    static String YoutubeDL = "youtube-dl";
    static String dir = "video";
    static String suffix = ".mp4";
    @Autowired
    VideoProperties videoProperties;

    public YoutubeDlUtils() {
        super(dir, suffix);
    }

    /**
     * 获取视频信息
     *
     * @param url
     * @return
     * @throws Exception
     */
    public List<YoutubeDL> getYoutubeDLSearchInfo(String url) throws Exception {
        return runCommandForGetYoutubeDLSearchInfo(url);
    }

    /**
     * command to get youtube_dl info
     *
     * @param url
     * @return
     * @throws Exception
     */
    private List<YoutubeDL> runCommandForGetYoutubeDLSearchInfo(String url) throws Exception {
        List<String> list = new ArrayList<>();
        list.add(YoutubeDL);
        list.add("-F");
        list.add(url);
        ProcessBuilder BUILD = new ProcessBuilder();
        BUILD.command(list);
        Process p = BUILD.start();
        p.waitFor();
        List<YoutubeDL> youtubeDLList = readCommandToYoutubeDL(p.getInputStream());
        p.destroy();
        return youtubeDLList;
    }

    /**
     * 读取command的输出转化成YoutubeDL
     *
     * @param inputStream
     * @return
     * @throws Exception
     */

    private List<YoutubeDL> readCommandToYoutubeDL(InputStream inputStream) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String line = null;
        boolean flag = false;
        List<YoutubeDL> youtubeDLList = new ArrayList<>();
        while ((line = bufferedReader.readLine()) != null) {
            if (flag == false) {
                if (line.contains("format code  extension  resolution note")) {
                    flag = true;
                    continue;
                }
            }
            if (flag == true) {
                String[] s = line.split("  ");
                List<String> stringList = deleteSpaceChar(s);
                YoutubeDL youtubeDL = new YoutubeDL(stringList.get(0), stringList.get(1).trim(), stringList.get(2), stringList.get(3));
                //只要mp4格式的
                if (!youtubeDL.getExtension().equalsIgnoreCase("mp4")) continue;
                youtubeDLList.add(youtubeDL);
            }
        }
        bufferedReader.close();
        inputStream.close();
        return youtubeDLList;
    }

    /**
     * 删除字符为空的string
     *
     * @param strings
     * @return
     */
    private List<String> deleteSpaceChar(String[] strings) {
        int length = strings.length;
        List<String> stringList = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            if (strings[i].length() > 0) {
                stringList.add(strings[i]);
            }
        }
        return stringList;
    }

    /**
     * 下载视频主函数
     *
     * @param videoInfo
     * @return
     * @throws Exception
     */

    public String getVideoFileByYoutubeDL(Map<String, String> videoInfo) throws Exception {
        String outputString = this.getFilePath(videoInfo.get("type"), videoInfo.get("videoName"));
        this.runCommandForDownloadYoutubeVideo(outputString, videoInfo.get("url"), videoInfo.get("code"));
        return outputString;
    }
    /**
     * 下载视频到指定目录
     * @param outputString
     * @param url
     * @param code
     * @throws Exception
     */
    private void runCommandForDownloadYoutubeVideo(String outputString,String url,String code)throws Exception{
        List<String> list = new ArrayList<>();
        list.add(YoutubeDL);
        list.add("-o");
        list.add(outputString);
        list.add("-f");
        list.add(code);
        list.add(url);
        ProcessBuilder BUILD = new ProcessBuilder();
        BUILD.command(list);
        Process p = BUILD.start();
        p.waitFor();
        p.destroy();
    }
}
