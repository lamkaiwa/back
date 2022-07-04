package cn.leolam.www.auth.web.mapper;

import cn.leolam.www.auth.web.entities.SysUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author leolam
 */

public interface SysUserMapper extends BaseMapper<SysUser> {
    /**
     * 根据页数查询用户信息
     * @param pageNumber
     * @param pageSize
     * @return
     */
    List<SysUser> findUserByPage(@Param("pageNumber") Integer pageNumber,
                                 @Param("pageSize") Integer pageSize);

    /**
     * user的总数
     * @return
     */
    Integer findAllUserNumber();

    /**
     * 更新一个user信息
     * @param sysUser
     * @return
     */
    Integer updateUserByUserName(SysUser sysUser);

    /**
     * 删除一个user
     * @param sysUser
     */
    Integer deleteOneUserByUsername(SysUser sysUser);

    /**
     * 获取用户
     * @param email
     * @return
     */
    SysUser getSysUserByEmail(@Param("email") String email);
}
