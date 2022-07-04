package cn.leolam.www.video.web.service.impl.admin;

import cn.leolam.www.video.exception.admin.AdminVideoException;
import cn.leolam.www.video.web.entities.Video;
import cn.leolam.www.video.web.mapper.CollectionListMapper;
import cn.leolam.www.video.web.mapper.TypeMapper;
import cn.leolam.www.video.web.mapper.VideoMapper;
import cn.leolam.www.video.web.mapper.ZanListMapper;
import cn.leolam.www.video.web.service.admin.AdminVideoService;
import cn.leolam.www.video.web.utils.ImageUtils;
import cn.leolam.www.video.web.utils.MPDUtils;
import cn.leolam.www.video.web.utils.VideoUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.List;

@Service
@Slf4j
@Transactional
public class AdminVideoServiceImpl implements AdminVideoService {
    @Autowired
    CollectionListMapper collectionListMapper;

    @Autowired
    ZanListMapper zanListMapper;

    @Autowired
    VideoMapper videoMapper;

    @Autowired
    TypeMapper typeMapper;

    @Autowired
    MPDUtils mpdUtils;

    @Autowired
    VideoUtils videoUtils;

    @Autowired
    ImageUtils imageUtils;

    @Override
    public Integer deleteVideoByVideoId(Long id, HttpServletRequest request) {
        try {
            Video video = videoMapper.getVideoById(Integer.parseInt(String.valueOf(id)));
            collectionListMapper.deleteCollectionListsByVideoId(Integer.parseInt(String.valueOf(id)));
            zanListMapper.deleteZanListsByVideoId(Integer.parseInt(String.valueOf(id)));
            videoMapper.deleteVideoByVideoId(Integer.parseInt(String.valueOf(id)));
            videoUtils.deleteVideoDashFile(String.valueOf(video.getType()), video.getVideoName());
            imageUtils.deleteFile(String.valueOf(video.getType()), video.getVideoName());
            mpdUtils.deleteVideoMPDFile(String.valueOf(video.getType()), video.getVideoName());
        } catch (Exception e) {
            log.info(e.getMessage());
            throw new AdminVideoException("删除一个视频失败");
        }
        return 1;
    }

    @Override
    public List<String> getType() {
        List<String> stringList = null;
        try {
            stringList = typeMapper.getAllType();
        }catch (Exception e){
            log.info(e.getMessage());
            throw new AdminVideoException("获取全部分类失败");
        }
        return stringList;
    }

    private void moveFile(Video video, Video preVideo) throws Exception {
        //移动视频
        FileUtils.copyFile(new File(videoUtils.getVideoDashPath(String.valueOf(preVideo.getType()),
                preVideo.getVideoName())), new File(videoUtils.getVideoDashPath(String.valueOf(video.getType()), video.getVideoName())));
        videoUtils.deleteVideoDashFile(String.valueOf(preVideo.getType()),preVideo.getVideoName());
        //移动mpd
        FileUtils.copyFile(new File(mpdUtils.getVideoMPDPath(String.valueOf(preVideo.getType()),preVideo.getVideoName())),
                new File(mpdUtils.getVideoMPDPath(String.valueOf(video.getType()),video.getVideoName())));
        mpdUtils.deleteVideoMPDFile(String.valueOf(preVideo.getType()),String.valueOf(preVideo.getVideoName()));
        //移动照片
        FileUtils.copyFile(new File(imageUtils.getFilePath(String.valueOf(preVideo.getType()),preVideo.getVideoName())),
                new File(imageUtils.getFilePath(String.valueOf(video.getType()),video.getVideoName())));
        imageUtils.deleteFile(String.valueOf(preVideo.getType()),preVideo.getVideoName());
    }

    @Override
    public Integer editVideo(Video video) {
        try {
            video.setAuthor(null);
            Video preVideo = videoMapper.getVideoById(Integer.parseInt(String.valueOf(video.getId())));

            if (video.getType() != preVideo.getType()) {
                moveFile(video,preVideo);
            }
            videoMapper.updateVideoByVideo(video);
        } catch (Exception e) {
            log.info(e.getMessage());
            throw new AdminVideoException("删除视频失败哦");
        }
        return 1;
    }
}
