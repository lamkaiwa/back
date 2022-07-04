package cn.leolam.www.user.web.service.impl.message;

import cn.leolam.www.user.exception.message.ReplyException;
import cn.leolam.www.user.web.entities.Message;
import cn.leolam.www.user.web.mapper.CommentMapper;
import cn.leolam.www.user.web.mapper.MessageMapper;
import cn.leolam.www.user.web.mapper.ReplyMapper;
import cn.leolam.www.user.web.mapper.UserMapper;
import cn.leolam.www.user.web.service.message.ReplyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
@Transactional
public class ReplyServiceImpl implements ReplyService {
    @Autowired
    MessageMapper messageMapper;

    @Autowired
    CommentMapper commentMapper;

    @Autowired
    UserMapper userMapper;

    @Autowired
    ReplyMapper replyMapper;

    @Override
    public List<Message> getMessages(Long userId) {
        List<Message> messageList = null;
        try {
            messageList = messageMapper.getMessagesByUserId(userId);
            for (Message m :
                    messageList) {
                Long commentId = (Long) m.getComment();
                m.setComment(commentMapper.getCommentById(commentId));
                m.setYou(userMapper.findUserByUserIdParam(Integer.parseInt(String.valueOf(m.getYou()))));
                m.setUser(userMapper.findUserByUserIdParam(Integer.parseInt(String.valueOf(m.getUser()))));
            }
        } catch (Exception e) {
            log.info(e.getMessage());
            throw new ReplyException("获取用户回复失败");
        }
        return messageList;
    }

    public Integer deleteMessage(Long id) {
        try {
            Message message = messageMapper.getMessageById(id);
            Long replyId = message.getReplyId();
            messageMapper.deleteMessageByReplyId(replyId);
            replyMapper.deleteReplyById(replyId);
        } catch (Exception e) {
            log.info(e.getMessage());
            throw new ReplyException("删除用户回复失败");
        }
        return 1;
    }

}
