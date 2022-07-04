package cn.leolam.www.user.web.entities;

import lombok.Data;

import java.io.Serializable;

/**
 * token实体类
 */
@Data
public class Token implements Serializable {
    private String access_token;
    private String token_type;
    private String refresh_token;
    private String expires_in;
    private String scope;
    private String jti;
}
