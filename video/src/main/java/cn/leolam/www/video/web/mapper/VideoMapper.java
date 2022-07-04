package cn.leolam.www.video.web.mapper;

import cn.leolam.www.video.web.entities.Video;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 视频mapper
 */
public interface VideoMapper {

    //获取有限根据分类的视频 以播放次数排序
    List<Video> getLimitTypeVideoOrderByPlayCount(@Param("page") Integer page,
                                              @Param("pageSize") Integer pageSize,
                                              @Param("type") Integer type
    );


    //获取视频的总数 根据类别
    Integer getAllVideoCountByType(@Param("type") Integer type);


    //模糊查询视频 以上传时间和播放次数
    List<Video> getSearchVideoByLikeSortTypeUserId(@Param("page")Integer page,
                                             @Param("pageSize")Integer pageSize,
                                             @Param("words") String words,
                                             @Param("sortType")String sortType,
                                             @Param("userId") Integer userId
    );
    //获取模糊查询的总数
    Integer getSearchVideoCountByLikeUserId(@Param("words") String words,@Param("userId")Integer userId);
    //删除一个视频
    Integer deleteVideoByVideoId(@Param("videoId") Integer videoId);
    //获取一条视频信息
    Video getVideoById(@Param("videoId") Integer videoId);
    //插入一条数据
    Integer insertVideoByVideo(Video video);
    //获取推荐视频
    List<Video> getRecommendVideoByTwoWordsAndSortType(@Param("page")Integer page,
                                                       @Param("pageSize")Integer pageSize,
                                                       @Param("title") String title,
                                                       @Param("sortType")String sortType,
                                                       @Param("userId") Integer userId,
                                                       @Param(("desc")) String desc
    );
    //播放量加一
    Integer updateVideoPlayCountByVideoId(@Param("videoId") Integer videoId);

    List<Video> getVideosByAuthor(@Param("userId") Long id);

    Integer updateVideoByVideo(Video video);
}
