package cn.leolam.www.user.web.service.impl.login;

import cn.leolam.www.user.exception.login.ReSetException;
import cn.leolam.www.user.properties.SecurityProperties;
import cn.leolam.www.user.web.entities.Code;
import cn.leolam.www.user.web.entities.User;
import cn.leolam.www.user.web.mapper.CodeMapper;
import cn.leolam.www.user.web.mapper.SysUserMapper;
import cn.leolam.www.user.web.mapper.UserMapper;
import cn.leolam.www.user.web.service.login.ResetService;
import cn.leolam.www.user.web.utils.QQEmailSender;
import cn.leolam.www.user.web.utils.RandomStringUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;

/**
 * 重置服务
 */
@Service
@Slf4j
@Transactional
public class ResetServiceImpl implements ResetService {
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    UserMapper userMapper;

    @Autowired
    CodeMapper codeMapper;

    @Autowired
    QQEmailSender qqEmailSender;

    @Autowired
    SecurityProperties securityProperties;

    @Autowired
    SysUserMapper sysUserMapper;

    @Override
    public boolean getCode(User user) {
        try {
            User user1 = userMapper.findUserByEmail(user);
            if (user1 == null) throw new ReSetException("没有此用户");
            Code code = new Code();
            code.setUserId(user1.getId());
            //删除以前的验证码
            codeMapper.deleteCodeByUserId(code);
            String randomCode = RandomStringUtils.getRandomString(4);
            code.setCode(randomCode);
            //发送验证码到邮箱
            qqEmailSender.sendEmail(user1.getEmail(), code.getCode());
            //添加code到数据库
            codeMapper.insertCodeByUserIdAndCode(code);
        }catch (Exception e){
            throw new ReSetException(e.getMessage());
        }
        return true;
    }

    @Override
    public boolean updatePass(User user) {
        try{
            User user1 = userMapper.findUserByEmail(user);
            if (user1 == null) throw new ReSetException("没有该用户");
            Code code = codeMapper.findCodeByUserId(user1.getId());
            if (code == null) throw new ReSetException("验证码错误,请重新获取");
            if (!code.getCode().equalsIgnoreCase(user.getCode().getCode())) throw new ReSetException("验证码输入错误");
//            if (!isExpireForCode(code.getTime().getTime())) throw new ReSetException("验证码已经过期请重新发送");
            //删除验证码
            codeMapper.deleteCodeByUserId(code);
            //加密 密码并且写入
            user1.setPassword(passwordEncoder.encode(user.getPassword()));
            userMapper.updatePassWordByUserId(user1);
            sysUserMapper.updatePassWordByEmail(user1.getEmail(),user1.getPassword());

        }catch (Exception e){
            throw new ReSetException(e.getMessage());
        }
        return true;
    }

    /**
     * 查看验证码是否过期
     *
     * @param startTime
     * @return
     */

    private boolean isExpireForCode(double startTime) {
        double expireTime = securityProperties.getCodeExpireTime().doubleValue();
        Date startDate = new Date(new java.util.Date().getTime());
        double end = startDate.getTime();
        //这里有个时间bug
        if ((end - startTime) / 1000 > expireTime) return true;
        return true;
    }
}
