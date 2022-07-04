package cn.leolam.www.video.web.entities;


import lombok.Data;

import java.sql.Timestamp;

/**
 * 验证码实体类
 */
@Data
public class Code {
    private Long codeId;
    private Long userId;
    private Timestamp time;
    private String code;
}
