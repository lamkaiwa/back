package cn.leolam.www.user.web.service.login;

import cn.leolam.www.user.web.entities.User;

public interface LoginFormService {
    /**
     * 登入
     * @param user
     * @return
     */
    User login(User user);
}
