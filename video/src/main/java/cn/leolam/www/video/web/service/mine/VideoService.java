package cn.leolam.www.video.web.service.mine;

import cn.leolam.www.video.web.entities.Video;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface VideoService {
    /**
     * 根据 page words sortBy and userId 查询videoList
     * @param page
     * @param words
     * @param sortBy
     * @param userId
     * @return
     */
    List<Video> getSearchVideoByLikeSortTypeUserId(Integer page, String words, String sortBy, Integer userId);

    /**
     * 获取模糊查询的总数
     * @param words
     * @param userId
     * @return
     */
    Integer getSearchVideoCountByLikeUserId(String words,Integer userId);

    /**
     * 删除视频
     * @param videId
     * @return
     */
    Integer deleteVideoById(@RequestParam("videoId") Integer videId);
}
