package cn.leolam.www.video.web.utils;

import cn.leolam.www.video.web.entities.VideoInfo;
import lombok.extern.slf4j.Slf4j;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
@Slf4j
public class MPDUtils extends CommonUtils {
    static String dir = "video";
    static String suffix = ".mpd";
    String append = "_dash";


    public MPDUtils() {
        super(dir, suffix);
    }

    public void deleteVideoMPDFile(String dir, String fileName)throws Exception {
        String filePath = getVideoMPDPath(dir, fileName);
        File file = new File(filePath);
        if (file.exists()) file.delete();
    }

    /**
     * 获取视频mpd路径
     *
     * @param dir
     * @return
     * @throws Exception
     */
    public String getVideoMPDPath(String dir, String fileName) throws Exception {
        String dirPath = getDirPath(dir);
        return dirPath + "/" + fileName + append + suffix;
    }

    /**
     * 读取视频mpd文件
     *
     * @param dir
     * @param name
     * @return
     * @throws Exception
     */
    public VideoInfo ReadVideoMPD(String dir, String name) throws Exception {
        String mpdPath = getVideoMPDPath(dir, name);
        //创建解析器
        SAXReader reader = new SAXReader();
        //解析文件的目录
        Document document = reader.read(new File(mpdPath));
        VideoInfo videoInfo = new VideoInfo();
        //获取根目录
        Element root = document.getRootElement();
        //返回时长 12h34m19.0s
        String time = root.attribute("mediaPresentationDuration").getValue();
        //计算总时长
        String pattern = "\\d+(?:\\.\\d+)?";
        double[] timeArr = new double[3];
        Matcher m = Pattern.compile(pattern, Pattern.MULTILINE).matcher(time);
        double finalRes = 0;
        int count = 3600;
        while (m.find()) {
            double x = Double.parseDouble(m.group());
            finalRes = finalRes + count * x;
            count = count / 60;
        }
        videoInfo.setVideoTime(String.valueOf(Math.floor(finalRes)));
        //获取RepresentationElement
        Element representation = root.element("Period").element("AdaptationSet").element("Representation");
        videoInfo.setMimeType(representation.attributeValue("mimeType"));
        videoInfo.setCodes(representation.attributeValue("codecs"));
        videoInfo.setWidth(representation.attributeValue("width"));
        videoInfo.setHeight(representation.attributeValue("height"));
        //获取切面SegmentList
        Element segmentList = representation.element("SegmentList");
        //获取分组片段值
        List<Element> elements = segmentList.elements();
        int size = elements.size();
        for (int i = 0; i < size; i++) {
            Element element = elements.get(i);
            String range = null;
            range = element.attributeValue("mediaRange");
            if (range == null) range = element.attributeValue("range");
            String[] nums = range.split("-");
            videoInfo.getSegment().add(new String[]{nums[0], nums[1]});
        }
        return videoInfo;
    }
}
