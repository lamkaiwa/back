package cn.leolam.www.user.web.service.login;


import cn.leolam.www.user.web.entities.User;

public interface ResetService {
    /**
     * 获取验证码
     * @param user
     * @return
     */
    boolean getCode(User user);
    boolean updatePass(User user);
}
