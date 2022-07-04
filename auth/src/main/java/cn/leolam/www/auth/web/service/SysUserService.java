package cn.leolam.www.auth.web.service;

import cn.leolam.www.auth.web.entities.SysUser;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 *  实现 IService<T> 接口，提供了常用更复杂的对 T 数据表的操作，
 *  比如：支持 Lambda 表达式，批量删除、自动新增或更新操作
 * @Auther: leolam
 */
public interface SysUserService extends IService<SysUser> {
    /**
     * 通过用户名查询
     * @param username 用户名
     * @return 用户信息
     */
    SysUser findByUsername(String username);

    /**
     * 通过手机号查询
     * @param email email号
     * @return 用户信息
     */
    SysUser findByEmail(String email);

    /**
     * 根据页数查询用户信息
     * @param pageNumber
     * @return
     */
    List<SysUser> findUserByPage(Integer pageNumber);

    /**
     * 查找user的总数
     * @return
     */
    Integer findAllUserNumber();

    /**
     * 更新一个user的信息
     * @param sysUser
     * @return
     */
    Integer updateUserByUserName(SysUser sysUser);

    /**
     * 删除一个user的信息
     * @param sysUser
     * @return
     */
    Integer deleteOneUserByUsername(SysUser sysUser);
}
