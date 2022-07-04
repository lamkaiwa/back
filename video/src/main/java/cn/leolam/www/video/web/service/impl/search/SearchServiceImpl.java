package cn.leolam.www.video.web.service.impl.search;



import cn.leolam.www.video.exception.search.SearchException;
import cn.leolam.www.video.properties.VideoProperties;
import cn.leolam.www.video.web.entities.Video;
import cn.leolam.www.video.web.mapper.VideoMapper;
import cn.leolam.www.video.web.service.search.SearchService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Slf4j
@Transactional
public class SearchServiceImpl implements SearchService {
    @Autowired
    VideoMapper videoMapper;

    @Autowired
    VideoProperties videoProperties;
    /**
     * 模糊查询视频 以上传时间和播放次数
     *
     * @param page
     * @param words
     * @param sortType
     * @return
     */
    @Override
    public List<Video> getSearchVideoByLikeSortType(Integer page, String words, String sortType) {
        List<Video> videoList = null;
        try {
            if (page == 0) page = 1;
            Integer pageSize = videoProperties.getPageSizeOnSearchPage();
            int start = (page - 1) * pageSize;
            videoList = videoMapper.getSearchVideoByLikeSortTypeUserId(start, pageSize, words, sortType,null);
        } catch (Exception e) {
            log.info(e.getMessage());
            throw new SearchException("视频获取异常");
        }
        return videoList;
    }

    /**
     * 获取视频总数
     * @param words
     * @return
     */
    @Override
    public Integer getSearchVideoCountByLikeUserId(String words,Integer userId) {
        Integer count = null;
        try {
            count= videoMapper.getSearchVideoCountByLikeUserId(words,null);
        }catch (Exception e){
            log.info(e.getMessage());
            throw new SearchException("获取查询总数错误");
        }
        return count;
    }
}
