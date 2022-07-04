package cn.leolam.www.user.web.service.login;

import cn.leolam.www.user.web.entities.User;

public interface SignInService {
    /**
     * 注册
     * @param user
     * @return
     */
    boolean reg(User user);
}
