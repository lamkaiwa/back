package cn.leolam.www.auth.web.service.impl;

import cn.leolam.www.auth.web.entities.SysUser;
import cn.leolam.www.auth.web.mapper.SysUserMapper;
import cn.leolam.www.auth.web.service.SysUserService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * ServiceImpl<M extends BaseMapper<T>, T> 是对 IService接口中方法的实现
 *     第1个泛型 M 指定继承了 BaseMapper接口的子接口
 *     第2个泛型 T 指定实体类
 * @Auther: leolam
 */
@Service
//事务
@Transactional
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {

    @Autowired
    PasswordEncoder passwordEncoder;
    @Override
    public SysUser findByUsername(String username) {
        QueryWrapper<SysUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", username);
        // baseMapper 对应的是 SysUserMapper 实例
        return baseMapper.selectOne(queryWrapper);
    }

    @Override
    public SysUser findByEmail(String email) {
        QueryWrapper<SysUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("email", email);
        // baseMapper 对应的是 SysUserMapper 实例
        return baseMapper.selectOne(queryWrapper);
    }

    @Override
    public List<SysUser> findUserByPage(Integer pageNumber) {
        if (pageNumber==0)pageNumber=1;
        Integer pageSize=5;
        int start=(pageNumber-1)*pageSize;
        return baseMapper.findUserByPage(start,pageSize);
    }

    @Override
    public Integer findAllUserNumber() {
        return baseMapper.findAllUserNumber();
    }

    @Override
    public Integer updateUserByUserName(SysUser sysUser) {
        SysUser preSysUser=findByUsername(sysUser.getUsername());
        if(sysUser.getPassword()!=preSysUser.getPassword()){
            sysUser.setPassword(passwordEncoder.encode(sysUser.getPassword()));
        }
        return baseMapper.updateUserByUserName(sysUser);
    }

    @Override
    public Integer deleteOneUserByUsername(SysUser sysUser) {
        return baseMapper.deleteOneUserByUsername(sysUser);
    }
}
