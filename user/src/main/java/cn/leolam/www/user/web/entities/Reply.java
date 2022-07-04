package cn.leolam.www.user.web.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.sql.Timestamp;

/**
 * 回复实体类
 */
@Data
public class Reply {
    Long id;
    Long commentId;
    Object from;
    Object to;
    String content;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    Timestamp date;
}
