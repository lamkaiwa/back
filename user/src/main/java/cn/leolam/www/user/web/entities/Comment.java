package cn.leolam.www.user.web.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.sql.Timestamp;
import java.util.List;

/**
 * 评论实体类
 */
@Data
public class Comment {
    Long id;
    Object author;
    String content;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    Timestamp date;
    Long videoId;
    List<Reply> replyList;
}
