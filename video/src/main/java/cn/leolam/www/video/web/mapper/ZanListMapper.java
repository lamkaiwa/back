package cn.leolam.www.video.web.mapper;

import cn.leolam.www.video.web.entities.ZanList;
import org.apache.ibatis.annotations.Param;

public interface ZanListMapper {
    //删除全部VideoId的zan
    Integer deleteZanListsByVideoId(@Param("videoId") Integer videoId);
    //该视频点赞次数
    Long getZanListCountByVideoId(@Param("videoId") Integer videoId);
    //用户是否点赞
    Integer getZanListCountByZanList(ZanList zanList);
    //删除该用户的点赞
    Integer deleteZanListByZanList(ZanList zanList);
    //插入一条点赞
    Integer insertZanListByZanList(ZanList zanList);
}
