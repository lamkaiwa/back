package cn.leolam.www.user.web.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * 用户实体类
 */
@Data
public class User {
    private Long id;
    private String nick;
    private Integer sex;
    private String headUrl;
    private String sign;
    private Long fansCount;
    private String email;
    //返回的时候不写入
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;
    private String token;
    private String role;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    //验证码
    private Code code;

}
