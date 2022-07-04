package cn.leolam.www.user.web.utils;

import cn.leolam.www.user.properties.SecurityProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

/**
 * httpclient
 */
@Component
public class RestTemplateUtils {
    @Autowired
    SecurityProperties securityProperties;

    @Autowired
    RestTemplate restTemplate;

    /**
     * 获取令牌
     * @param url 链接地址
     * @param headers 请求头信息
     * @param params 参数
     * @return
     */
    public ResponseEntity<Map> sendToAuthGetUserToken(String url, HttpHeaders headers, MultiValueMap<String, Object> params){
        url=securityProperties.getGateWayUrl()+url;
        ResponseEntity<Map> responseEntity=restTemplate.postForEntity(url,new HttpEntity<>(params, headers), Map.class);
        return responseEntity;
    }
}
