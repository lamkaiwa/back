package cn.leolam.www.video.web.service.impl.webupload;

import cn.leolam.www.video.exception.webupload.WebUploadException;
import cn.leolam.www.video.web.entities.Video;
import cn.leolam.www.video.web.entities.YoutubeDL;
import cn.leolam.www.video.web.mapper.VideoMapper;
import cn.leolam.www.video.web.service.webupload.WebUploadService;
import cn.leolam.www.video.web.utils.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
@Slf4j
@Transactional
public class WebUploadServiceImpl implements WebUploadService {
    @Autowired
    YoutubeDlUtils youtubeDlUtils;
    @Autowired
    Mp4BoxUtils mp4BoxUtils;
    @Autowired
    VideoMapper videoMapper;
    @Autowired
    VideoUtils videoUtils;
    @Autowired
    MPDUtils mpdUtils;
    @Autowired
    FFMPEGUtils ffmpegUtils;
    @Autowired
    QQEmailSender qqEmailSender;


    @Override
    public List<YoutubeDL> getYoutubeDLsByUrl(String url) {
        List<YoutubeDL> youtubeDLList = null;
        try {
            youtubeDLList = youtubeDlUtils.getYoutubeDLSearchInfo(url);
        } catch (Exception e) {
            log.info(e.getMessage());
            throw new WebUploadException("获取链接视频失败", null, null);
        }
        return youtubeDLList;
    }

    @Override
    public void downLoadVideoByYoutubeDl(Map<String, String> videoInfo) {
        try {
            videoInfo.put("videoName", UUID.randomUUID().toString());
            Video video = setVideoProperties(videoInfo);
            youtubeDlUtils.getVideoFileByYoutubeDL(videoInfo);
            mp4BoxUtils.createDashMp4(videoInfo.get("type"), videoInfo.get("videoName"));
            ffmpegUtils.getImagePicOnFirstTime(videoInfo.get("type"), videoInfo.get("videoName"),"2");
            videoUtils.deleteFile(videoInfo.get("type"), videoInfo.get("videoName"));
            videoMapper.insertVideoByVideo(video);
            qqEmailSender.sendEmail(videoInfo.get("email"),"你的视频："+videoInfo.get("title")+"上传成功");
        } catch (Exception e) {
            try {
                videoUtils.deleteFile(videoInfo.get("type"), videoInfo.get("videoName"));
                mpdUtils.deleteVideoMPDFile(videoInfo.get("type"), videoInfo.get("videoName"));
                videoUtils.deleteVideoDashFile(videoInfo.get("type"), videoInfo.get("videoName"));
                qqEmailSender.sendEmail(videoInfo.get("email"),"你的视频："+videoInfo.get("title")+"上传失败");
            } catch (Exception ex) {
                log.info(e.getMessage());
                throw new WebUploadException("下载web视频失败", null, null);
            }
            log.info(e.getMessage());
            throw new WebUploadException("下载web视频失败", null, null);
        }
    }

    private Video setVideoProperties(Map<String, String> videoInfo) {
        Video video = new Video();
        video.setAuthor(Integer.parseInt(String.valueOf(videoInfo.get("author"))));
        video.setTitle(videoInfo.get("title"));
        video.setType(Long.parseLong(String.valueOf(videoInfo.get("type"))));
        video.setDesc(videoInfo.get("desc"));
        video.setImageName(videoInfo.get("videoName"));
        video.setVideoName(videoInfo.get("videoName"));
        return video;
    }

}
