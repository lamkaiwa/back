package cn.leolam.www.user.web.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.sql.Timestamp;
@Data
public class Notice {
    Long id;
    String title;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    Timestamp date;
    String content;
    String url;
}
