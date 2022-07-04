package cn.leolam.www.video.web.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Timestamp;

/**
 * 视频实体
 */

@Data
public class Video {
    Long id;
    Long playCount;
    Long collectCount;
    Long zanCount;
    Object author;
    String title;
    Long type;
    String desc;
    //变成json的时候应该如何解析
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
//    @DateTimeFormat(pattern = “yyyy-MM-dd”)  格式时的
    Timestamp uploadTime;
    String imageName;
    String videoName;
    Integer pageSize;
    boolean isCollect;
    boolean isZan;
}
