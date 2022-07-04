package cn.leolam.www.video.web.service.impl.mine;

import cn.leolam.www.video.exception.mine.VideoException;
import cn.leolam.www.video.exception.search.SearchException;
import cn.leolam.www.video.properties.VideoProperties;
import cn.leolam.www.video.web.entities.Video;
import cn.leolam.www.video.web.mapper.CollectionListMapper;
import cn.leolam.www.video.web.mapper.VideoMapper;
import cn.leolam.www.video.web.mapper.ZanListMapper;
import cn.leolam.www.video.web.service.mine.VideoService;
import cn.leolam.www.video.web.utils.ImageUtils;
import cn.leolam.www.video.web.utils.MPDUtils;
import cn.leolam.www.video.web.utils.VideoUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
@Transactional
public class VideoServiceImpl implements VideoService {
    @Autowired
    VideoMapper videoMapper;
    @Autowired
    ZanListMapper zanListMapper;
    @Autowired
    CollectionListMapper collectionListMapper;

    @Autowired
    VideoUtils videoUtils;

    @Autowired
    ImageUtils imageUtils;
    @Autowired
    MPDUtils mpdUtils;

    @Autowired
    VideoProperties videoProperties;
    @Override
    public List<Video> getSearchVideoByLikeSortTypeUserId(Integer page, String words, String sortBy, Integer userId) {
        List<Video> videoList = null;
        try {
            if (page == 0) page = 1;
            Integer pageSize = videoProperties.getPageSizeOnSearchPage();
            int start = (page - 1) * pageSize;
            videoList = videoMapper.getSearchVideoByLikeSortTypeUserId(start, pageSize, words, sortBy,userId);
        } catch (Exception e) {
            log.info(e.getMessage());
            throw new VideoException("视频获取异常");
        }
        return videoList;
    }

    @Override
    public Integer getSearchVideoCountByLikeUserId(String words, Integer userId) {
        Integer count = null;
        try {
            count= videoMapper.getSearchVideoCountByLikeUserId(words,userId);
        }catch (Exception e){
            log.info(e.getMessage());
            throw new VideoException("获取查询总数错误");
        }
        return count;
    }

    @Override
    public Integer deleteVideoById(Integer videoId) {
        try {
            Video video=videoMapper.getVideoById(videoId);
            zanListMapper.deleteZanListsByVideoId(videoId);
            collectionListMapper.deleteCollectionListsByVideoId(videoId);
            videoUtils.deleteVideoDashFile(String.valueOf(video.getType()),String.valueOf(video.getVideoName()));
            mpdUtils.deleteVideoMPDFile(String.valueOf(video.getType()),String.valueOf(video.getVideoName()));
            imageUtils.deleteFile(String.valueOf(video.getType()),video.getVideoName());
            videoMapper.deleteVideoByVideoId(videoId);
        }catch (Exception e){
            log.info(e.getMessage());
            throw new VideoException("删除失败");
        }

        return 1;
    }
}
