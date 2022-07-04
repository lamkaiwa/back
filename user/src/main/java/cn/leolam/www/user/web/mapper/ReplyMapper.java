package cn.leolam.www.user.web.mapper;

import cn.leolam.www.user.web.entities.Reply;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ReplyMapper {
    /**
     * 获取所有的回复
     * @param commentId
     * @return
     */
    List<Reply> getReplysByCommentId(@Param("commentId") Integer commentId);

    /**
     * 插入一条回复
     * @param reply
     * @return
     */
    Integer insertReplyByReply(Reply reply);

    /**
     * 删除该评论下的所有回复
     * @param commentId
     * @return
     */
    Integer deleteReplysByCommentId(@Param("commentId") Long commentId);

    /**
     * 删除一条回复
     * @param id
     * @return
     */
    Integer deleteReplyById(@Param("id") Long id);

    /**
     * 获取最后一个id
     * @return
     */
    Integer getLastReplyId();

    Integer deleteReplysByFromOrTo(@Param("userId") Long id);


}
