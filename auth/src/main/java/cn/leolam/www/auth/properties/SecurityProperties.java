package cn.leolam.www.auth.properties;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Auther: leolam
 */
@Component // 不要少了
@ConfigurationProperties(prefix = "auth")
@Data
public class SecurityProperties {
    private String clientId;
    private String clientPassword;
    private String username;
    private String password;
    private String tokenString;
    public String getAuthorization(){
        String authorization=this.clientId+":"+this.clientPassword;
        return "Basic "+authorization;
    }
}
