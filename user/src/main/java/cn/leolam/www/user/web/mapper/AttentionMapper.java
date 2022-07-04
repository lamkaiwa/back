package cn.leolam.www.user.web.mapper;

import cn.leolam.www.user.web.entities.Attention;
import org.apache.ibatis.annotations.Param;

public interface AttentionMapper {
    Integer deleteAttentionByUserIdAndFans(Attention attention);
    Integer getAttentionCountByUserId(Attention attention);
    Integer getAttentionExistByUserIdAndFans(Attention attention);
    Integer insertAttentionByByUserIdAndFans(Attention attention);
    Integer deleteAttentionsByUserIdOrFans(@Param("userId") Long id);
}
