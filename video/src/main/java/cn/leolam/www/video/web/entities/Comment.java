package cn.leolam.www.video.web.entities;

import lombok.Data;

import java.sql.Timestamp;
import java.util.List;

@Data
public class Comment {
    Long id;
    Object author;
    String content;
    Timestamp date;
    Long videoId;
    List<Reply> replyList;
}
