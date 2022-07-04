package cn.leolam.www.user.web.service.impl.detail;

import cn.leolam.www.user.exception.detail.DetailException;
import cn.leolam.www.user.web.entities.Comment;
import cn.leolam.www.user.web.entities.Message;
import cn.leolam.www.user.web.entities.Reply;
import cn.leolam.www.user.web.entities.User;
import cn.leolam.www.user.web.mapper.CommentMapper;
import cn.leolam.www.user.web.mapper.MessageMapper;
import cn.leolam.www.user.web.mapper.ReplyMapper;
import cn.leolam.www.user.web.mapper.UserMapper;
import cn.leolam.www.user.web.service.detail.DetailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
@Transactional
public class DetailServiceImpl implements DetailService {
    @Autowired
    CommentMapper commentMapper;
    @Autowired
    UserMapper userMapper;
    @Autowired
    ReplyMapper replyMapper;

    @Autowired
    MessageMapper messageMapper;

    @Override
    public List<Comment> getVideoComments(Integer videoId) {
        List<Comment> commentList = null;
        try {
            commentList = commentMapper.getCommentsByVideoId(videoId);
            setAuthor(commentList);
        } catch (Exception e) {
            log.info(e.getMessage());
            throw new DetailException("获取评论失败");
        }
        return commentList;
    }

    @Override
    public Integer getCommentCount(Long videoId) {
        Integer count = null;
        try {
            count = commentMapper.getCommentCountByVideoId(videoId);
        } catch (Exception e) {
            log.info(e.getMessage());
            throw new DetailException("获取评论数目失败");
        }
        return count;
    }

    @Override
    public Integer addComment(Comment comment) {
        Integer integer = null;
        try {
            integer = commentMapper.insertCommentByComment(comment);
        } catch (Exception e) {
            log.info(e.getMessage());
            throw new DetailException("添加评论失败");
        }
        return integer;
    }

    @Override
    public Integer addReply(Message message) {
        try {
            Reply reply = new Reply();
            reply.setCommentId(Long.parseLong(String.valueOf(message.getComment())));
            reply.setFrom(Long.parseLong(String.valueOf(message.getYou())));
            reply.setTo(Long.parseLong(String.valueOf(message.getUser())));
            reply.setContent(message.getYouSay());
            replyMapper.insertReplyByReply(reply);
            Integer replyId = replyMapper.getLastReplyId();
            message.setReplyId(Long.parseLong(String.valueOf(replyId)));
            messageMapper.insertMessageByMessage(message);
        } catch (Exception e) {
            log.info(e.getMessage());
            throw new DetailException("插入回复失败");
        }
        return 1;
    }

    @Override
    public Integer deleteComment(Long id) {
        try {
            replyMapper.deleteReplysByCommentId(id);
            commentMapper.deleteCommentById(id);
            messageMapper.deleteMessagesByCommentId(id);
        } catch (Exception e) {
            log.info(e.getMessage());
            throw new DetailException("删除评论失败");
        }
        return 1;
    }

    @Override
    public Integer deleteReply(Long id) {
        try {
            replyMapper.deleteReplyById(id);
            messageMapper.deleteMessageByReplyId(id);
        } catch (Exception e) {
            log.info(e.getMessage());
            throw new DetailException("删除回复失败");
        }
        return 1;
    }

    /**
     * 获取评论者信息
     *
     * @param commentList
     */
    private void setAuthor(List<Comment> commentList) {
        for (Comment c :
                commentList) {
            Long userId = (Long) c.getAuthor();
            User user = userMapper.findUserByUserIdParam(Integer.parseInt(String.valueOf(userId)));
            c.setAuthor(user);
            for (Reply reply :
                    c.getReplyList()) {
                Long fromId = (Long) reply.getFrom();
                Long toId = (Long) reply.getTo();
                reply.setFrom(userMapper.findUserByUserIdParam(Integer.parseInt(String.valueOf(fromId))));
                reply.setTo(userMapper.findUserByUserIdParam(Integer.parseInt(String.valueOf(toId))));
            }
        }
    }
}
