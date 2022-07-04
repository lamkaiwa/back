package cn.leolam.www.video.web.service.mine;

import cn.leolam.www.video.web.entities.CollectionList;
import cn.leolam.www.video.web.entities.Video;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface CollectionService {
    /**
     * 获取该用户收藏的video
     *
     * @param userId
     * @param request
     * @return
     */
    List<Video> getCollectionVideoListByUserId(Integer userId, Integer page, HttpServletRequest request);

    /**
     * 获取收藏的总数
     * @param userId
     * @return
     */
    Integer getAttentionCountByUserId(Integer userId);

    /**
     * 用户取消点赞
     * @param collectionList
     * @return
     */
    Integer deleteCollectionListByVideoIdAndUserId(CollectionList collectionList);
}
