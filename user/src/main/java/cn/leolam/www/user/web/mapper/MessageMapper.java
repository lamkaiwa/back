package cn.leolam.www.user.web.mapper;

import cn.leolam.www.user.web.entities.Message;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MessageMapper {
    Integer insertMessageByMessage(Message message);
    Integer deleteMessagesByCommentId(@Param("commentId") Long commentId);
    Integer deleteMessageByReplyId(@Param("replyId") Long replyId);
    List<Message> getMessagesByUserId(@Param("userId") Long userId);
    Message getMessageById(@Param("id") Long id);
    Integer deleteMessagesByYouOrUser(@Param("userId") Long id);
}
