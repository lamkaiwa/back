package cn.leolam.www.video.web.entities;

import lombok.Data;

import java.sql.Timestamp;
@Data
public class Reply {
    Long id;
    Long commentId;
    Object from;
    Object to;
    String content;
    Timestamp date;
}
