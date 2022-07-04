package cn.leolam.www.video.web.service.webupload;

import cn.leolam.www.video.web.entities.YoutubeDL;

import java.util.List;
import java.util.Map;

public interface WebUploadService {
    List<YoutubeDL> getYoutubeDLsByUrl(String url);
    void downLoadVideoByYoutubeDl(Map<String, String> videoInfo);
}
