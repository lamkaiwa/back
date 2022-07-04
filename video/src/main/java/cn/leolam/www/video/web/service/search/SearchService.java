package cn.leolam.www.video.web.service.search;

import cn.leolam.www.video.web.entities.Video;

import java.util.List;

public interface SearchService {
    //模糊查询视频 以上传时间和播放次数
    List<Video> getSearchVideoByLikeSortType(Integer page, String words, String sortType);

    //获取模糊查询的总数
    Integer getSearchVideoCountByLikeUserId(String words,Integer userId);
}
