package cn.leolam.www.user.web.service.impl.login;

import cn.leolam.www.user.exception.login.SignInException;
import cn.leolam.www.user.web.entities.User;
import cn.leolam.www.user.web.mapper.SysUserMapper;
import cn.leolam.www.user.web.mapper.UserMapper;
import cn.leolam.www.user.web.service.login.SignInService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Slf4j
@Transactional
public class SignInServiceImpl implements SignInService {

    @Autowired
    UserMapper userMapper;
    @Autowired
    SysUserMapper sysUserMapper;

    @Autowired
    PasswordEncoder passwordEncoder;



    @Override
    public boolean reg(User user) {
        try {
            User user1 = userMapper.findUserByEmail(user);
            if (user1 == null) {
                user1 = new User();
                user1.setEmail(user.getEmail());
                user1.setPassword(passwordEncoder.encode(user.getPassword()));
                userMapper.insertUserByEmailAndPassword(user1);
                Long userId = userMapper.getLastUserId();
                sysUserMapper.insertSysUserByEmailAndPassWordAndUsersId(userId,user1.getPassword(),user1.getEmail());
            } else {
                throw new SignInException("用户已经存在");
            }
        }catch (Exception e){
            log.info(e.getMessage());
            throw new SignInException(e.getMessage());
        }
        return true;
    }

}
