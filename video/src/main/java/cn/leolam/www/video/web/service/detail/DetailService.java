package cn.leolam.www.video.web.service.detail;

import cn.leolam.www.video.web.entities.CollectionList;
import cn.leolam.www.video.web.entities.Video;
import cn.leolam.www.video.web.entities.VideoInfo;
import cn.leolam.www.video.web.entities.ZanList;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public interface DetailService {
    Video getVideoByVideoId(Integer videoId, HttpServletRequest request);

    List<Video> getRecommendVideosByWord(Integer page, String title, String desc, String sortType, Integer userId, HttpServletRequest request);

    void getVideoBytes(String dir, String fileName, HttpServletResponse response);

    Integer updateVideoPlayCountByVideoId(Integer videoId);

    void readVideoBlock(Integer type, String fileName, Integer block, HttpServletResponse response);

    VideoInfo getVideoInfo(Integer type, String fileName);

    void getImageBytesOnSpecifiedTime(Integer type, String videoName, String time, HttpServletResponse response);

    Integer addZan(ZanList zanList);

    Integer addCollection(CollectionList collectionList);

    Integer isZan(ZanList zanList);

    Integer isCollectionList(CollectionList collectionList);

    Integer deleteZan(ZanList zanList);

    Integer deleteCollection(CollectionList collectionList);
    
}
