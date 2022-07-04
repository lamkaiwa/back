package cn.leolam.www.video.web.service.impl.admin;

import cn.leolam.www.video.exception.admin.UserException;
import cn.leolam.www.video.web.entities.Video;
import cn.leolam.www.video.web.mapper.CollectionListMapper;
import cn.leolam.www.video.web.mapper.VideoMapper;
import cn.leolam.www.video.web.mapper.ZanListMapper;
import cn.leolam.www.video.web.service.admin.AdminUserService;
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
public class AdminUserServiceImpl implements AdminUserService {
    @Autowired
    VideoMapper videoMapper;
    @Autowired
    ZanListMapper zanListMapper;
    @Autowired
    CollectionListMapper collectionListMapper;

    @Autowired
    ImageUtils imageUtils;
    @Autowired
    MPDUtils mpdUtils;
    @Autowired
    VideoUtils videoUtils;

    @Override
    public Integer deleteUser(Long id) {
        try {
            List<Video> videoList = videoMapper.getVideosByAuthor(id);
            for (Video v :
                    videoList) {
                zanListMapper.deleteZanListsByVideoId(Integer.parseInt(String.valueOf(v.getId())));
                collectionListMapper.deleteCollectionListsByVideoId(Integer.parseInt(String.valueOf(v.getId())));
                videoMapper.deleteVideoByVideoId(Integer.parseInt(String.valueOf(v.getId())));
                imageUtils.deleteFile(String.valueOf(v.getType()), v.getVideoName());
                mpdUtils.deleteVideoMPDFile(String.valueOf(v.getType()), v.getVideoName());
                videoUtils.deleteVideoDashFile(String.valueOf(v.getType()), v.getVideoName());
            }
        } catch (Exception e) {
            log.info(e.getMessage());
            throw new UserException("删除user相关的视频失败");
        }
        return 1;
    }
}
