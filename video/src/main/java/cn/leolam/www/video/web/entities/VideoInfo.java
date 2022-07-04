package cn.leolam.www.video.web.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class VideoInfo {
    //视频时间
    String videoTime;
    //宽
    String width;
    //高
    String height;
    //视频类型
    String mimeType;
    //编码方式
    String codes;
    //视频切片
    @JsonIgnore
    List<String[]> segment=new ArrayList<>();
}
