package cn.leolam.www.video.web.entities;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class YoutubeDL {
    String formatCode;
    String extension;
    String resolution;
    String note;
}
