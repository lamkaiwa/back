package cn.leolam.www.user.web.mapper;

import cn.leolam.www.user.web.entities.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    //查找一名user信息  email and password
    User findUserByEmailAndPassword(User user);
    //插入一条user信息
    Integer insertUserByEmailAndPassword(User user);
    //查找一名user信息 email
    User findUserByEmail(User user);
    //更新密码
    Integer updatePassWordByUserId(User user);
    //更新用户  fansCount 不会跟新 如果fansCount==null 就自增一 其他的不是null就更新
    Integer updateUserByUserId(User user);
    //获取关注的列表
    List<User> getUsersByUserIdThroughAttention(User user);
    //透过userid查找user
    User findUserByUserId(User user);
    //透过userid查找user
    User findUserByUserIdParam(@Param("userId") Integer userId);
    //根据page获取用户
    List<User> getUsersByPage(@Param("page")Integer page,@Param("pageSize") Integer pageSize);
    //获取用户的总数
    Integer getUsersCount();
    //插入一条信息
    Integer insertUserByUser(User user);
    //删除一个用户信息
    Integer deleteUserById(@Param("id") Long id);
    //获取最新插入的用户
    Long getLastUserId();
}
