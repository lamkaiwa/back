package cn.leolam.www.user.web.service.admin;


import cn.leolam.www.user.web.entities.User;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface AdminUserService {
    public List<User> getUsers(Integer page);
    public Integer getUsersCount();
    public Integer insertUser(User user);
    public Integer deleteUser(Long id, HttpServletRequest request);
    public Integer updateUser(User user);
}
