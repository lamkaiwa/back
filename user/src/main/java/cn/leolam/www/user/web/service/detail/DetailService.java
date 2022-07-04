package cn.leolam.www.user.web.service.detail;

import cn.leolam.www.user.web.entities.Comment;
import cn.leolam.www.user.web.entities.Message;
import cn.leolam.www.user.web.entities.Reply;

import java.util.List;

public interface DetailService {
    //获取评论信息
    public List<Comment> getVideoComments(Integer videoId);
    //添加评论
    public Integer addComment(Comment comment);
    //获取videoId 评论的数目
    public Integer getCommentCount(Long videoId);
    //插入一条回复
    public Integer addReply(Message message);
    //删除一条评论
    public Integer deleteComment(Long id);
    //删除一条回复
    public Integer deleteReply(Long id);
}
