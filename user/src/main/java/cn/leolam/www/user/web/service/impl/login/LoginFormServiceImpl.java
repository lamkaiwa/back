package cn.leolam.www.user.web.service.impl.login;

import cn.leolam.www.user.exception.login.LoginFormException;
import cn.leolam.www.user.properties.SecurityProperties;
import cn.leolam.www.user.web.entities.Token;
import cn.leolam.www.user.web.entities.User;
import cn.leolam.www.user.web.mapper.UserMapper;
import cn.leolam.www.user.web.service.login.LoginFormService;
import cn.leolam.www.user.web.utils.RestTemplateUtils;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.util.Map;

/**
 * 登入服务
 */
@Service
@Transactional
public class LoginFormServiceImpl implements LoginFormService {
    @Autowired
    UserMapper userMapper;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    SecurityProperties securityProperties;

    @Autowired
    RestTemplateUtils restTemplateUtils;

    @Override
    public User login(User user) {
        User user1 = null;
        try {
            user1 = userMapper.findUserByEmail(user);
            user1=userMapper.findUserByUserId(user1);
            if (user1 == null) throw new LoginFormException("用户不存在");
            if (!passwordEncoder.matches(user.getPassword(), user1.getPassword())) throw new LoginFormException("密码错误");
            //获取token的请求头
            HttpHeaders headers = new HttpHeaders();
            headers.add("Authorization", securityProperties.getAuthorization());
            headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
            //获取token的键值对
            MultiValueMap<String, Object> params = new LinkedMultiValueMap<>();
            params.add("grant_type", securityProperties.getOauth2Method());
            params.add("username",user.getEmail());
            params.add("password", user.getPassword());
            ResponseEntity<Map> responseEntity = restTemplateUtils.sendToAuthGetUserToken(securityProperties.getOauth2GetTokenUrl(), headers, params);
            Map<String, String> map = responseEntity.getBody();
            String json = JSONObject.toJSONString(map);
            Token token=JSONObject.parseObject(json, Token.class);
            if (token == null) throw new LoginFormException("登入错误");
            user1.setToken("Bearer " + token.getAccess_token());
        }catch (Exception e){
            throw new LoginFormException(e.getMessage());
        }
        return user1;
    }
}
