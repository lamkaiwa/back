package cn.leolam.www.user.properties;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

/**
 * @Auther: leolam
 */
@Component // 不要少了
@ConfigurationProperties(prefix = "auth")
@Data
public class SecurityProperties {
    //项目位置
    private String itemDir;
    //oauth2 clientId
    private String clientId;
    private String clientPassword;
    //ouath2 用户名
    private String username;
    private String password;
    //加密盐
    private String tokenString;
    //网关地址
    private String gateWayUrl;
    //密码模式 oauth2
    private String oauth2Method;
    //oauth2 获取令牌的url
    private String oauth2GetTokenUrl;
    private String emailAddress;
    //邮箱stmp码
    private String emailPassWord;
    //验证码过期时间
    private Integer codeExpireTime;
    private Integer userPageSize;
    private Integer pageSizeOnNoticePage;
    public String getAuthorization(){
        String authorization=this.clientId+":"+this.clientPassword;
        return "Basic "+(Base64.getEncoder().encodeToString(authorization.getBytes(StandardCharsets.UTF_8)));
    }
}
