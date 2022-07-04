package cn.leolam.www.user.web.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

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
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    Timestamp uploadTime;
    String imageName;
    String videoName;
    Integer pageSize;
    boolean isCollect;
    boolean isZan;
}
