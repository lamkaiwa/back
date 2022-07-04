package cn.leolam.www.user.web.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.sql.Timestamp;
@Data
public class Message {
    Long id;
    Object comment;
    Object you;
    String youSay;
    Object user;
    String content;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    Timestamp date;
    Long replyId;

}
