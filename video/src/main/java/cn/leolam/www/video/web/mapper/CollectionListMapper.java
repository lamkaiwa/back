package cn.leolam.www.video.web.mapper;

import cn.leolam.www.video.web.entities.CollectionList;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CollectionListMapper {
    //删除全部VideoId的收藏
    Integer deleteCollectionListsByVideoId(@Param("videoId") Integer videoId);
    //获取该用户的收藏
    List<CollectionList> getCollectionListsByUserId(@Param("userId") Integer userId,@Param("page") Integer page,@Param("pageSize") Integer pageSize);
    //获取用户收藏的数目
    Integer getCollectionListCountByUserId(@Param("userId") Integer userId);
    //获取该视频有多少收藏
    Long getCollectionListCountByVideoId(@Param("videoId") Integer videoId);
    //取消用户对这个视频的收藏
    Integer deleteCollectionListByCollectionList(CollectionList collectionList);
    //插入一个用户收藏
    Integer insertCollectionListByCollectionList(CollectionList collectionList);
    //查看用户是否收藏
    Integer getCollectionListCountByCollectionList(CollectionList collectionList);
}
