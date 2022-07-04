package cn.leolam.www.user.web.mapper;

import org.apache.ibatis.annotations.Param;

public interface SysUserMapper {
    Integer insertSysUserByEmailAndPassWord(@Param("email") String email,@Param("password") String password);
    Integer updatePassWordByEmail(@Param("email") String email,@Param("password") String password);
    Integer deleteUserByEmail(@Param("email")String email);
    Integer updatePassWordEmailByUsersId(@Param("usersId") Long usersId,@Param("password") String password,@Param("email") String email);
    Integer insertSysUserByEmailAndPassWordAndUsersId(@Param("usersId") Long usersId,@Param("password") String password,@Param("email") String email);
}
