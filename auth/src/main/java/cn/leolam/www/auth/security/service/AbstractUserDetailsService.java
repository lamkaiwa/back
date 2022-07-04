package cn.leolam.www.auth.security.service;


import cn.leolam.www.auth.web.entities.SysUser;
import cn.leolam.www.auth.web.mapper.SysUserMapper;
import cn.leolam.www.auth.web.service.SysUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;


/**
 * 查询数据库中的用户信息
 * @Auther: leolam
 */
@Component("customUserDetailsService")
public class AbstractUserDetailsService implements UserDetailsService {
    Logger logger=LoggerFactory.getLogger(getClass());
    @Autowired
    SysUserMapper sysUserMapper;
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        SysUser sysUser=sysUserMapper.getSysUserByEmail(s);
        sysUser.setGetAuthorities(sysUser.getAuthoritiesString());
        return sysUser;
    }
}
