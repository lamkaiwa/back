package cn.leolam.www.user.web.mapper;

import cn.leolam.www.user.web.entities.Comment;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CommentMapper {
    /**
     * 获取所有的评论
     * @param videoId
     * @return
     */
    List<Comment> getCommentsByVideoId(@Param("videoId") Integer videoId);

    /**
     * 插入一条评论
     * @param comment
     * @return
     */
    Integer insertCommentByComment(Comment comment);

    /**
     * 获取该video评论的数目
     * @param videoId
     * @return
     */
    Integer getCommentCountByVideoId(Long videoId);

    /**
     * 删除一条评论
     * @param id
     * @return
     */
    Integer deleteCommentById(@Param("id") Long id);

    /**
     * 获取一条评论
     * @param commentId
     * @return
     */
    Comment getCommentById(@Param("commentId") Long commentId);

    Integer deleteCommentsByAuthor(@Param("userId") Long userId);
}
