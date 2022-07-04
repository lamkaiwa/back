package cn.leolam.www.gateway.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Auther: leolam
 */
@Component // 不要少了
@ConfigurationProperties(prefix = "gateway")
public class GateWayProperties {
    private String tokenString="leolam";

    public String getTokenString() {
        return tokenString;
    }

    public void setTokenString(String tokenString) {
        this.tokenString = tokenString;
    }
}
