package cn.leolam.www.user.web.entities;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.sql.Date;
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
