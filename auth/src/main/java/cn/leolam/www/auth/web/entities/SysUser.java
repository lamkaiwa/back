package cn.leolam.www.auth.web.entities;

import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

@Data
@JsonIgnoreProperties({"getAuthorities","authorities"})
public class SysUser implements UserDetails {
    /**
     * 角色名称
     */
    private String username;
    /**
     * 角色密码
     */
    private String password;
    /**
     * 角色email
     */
    private String email;
    /**
     * 角色电话
     */
    private String phone;
    /**
     * 帐户是否过期(true(1) 未过期，false(0)已过期)
     * 设置默认值为true，新增用户默认未过期
     */
    private boolean isAccountNonExpired = true;
    /**
     * 帐户是否被锁定(true(1) 未过期，false(0)已过期)
     * 设置默认值为true，新增用户默认未过期
     */
    private boolean isAccountNonLocked = true;
    /**
     * 密码是否过期(true(1) 未过期，false(0)已过期)
     * 设置默认值为true，新增用户默认未过期
     */
    private boolean isCredentialsNonExpired = true;
    /**
     * 帐户是否可用(true(1) 可用，false(0)未删除)
     * 设置默认值为true，新增用户默认未过期
     */
    private boolean isEnabled = true;
    /**
     * 角色集合的字符串
     */
    private String authoritiesString;
    /**
     * 角色授权
     */
    @TableField(exist = false)
    //lombok 不生成get set
    @Setter(AccessLevel.NONE)
    Collection<? extends GrantedAuthority> getAuthorities;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.getAuthorities;
    }

    /**
     *
     * @param val 角色集合字符串
     */
    public void setGetAuthorities(String val){
        String[] strings =val.split(",");
        this.getAuthorities= AuthorityUtils.createAuthorityList(strings);
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return this.isAccountNonExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return this.isAccountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return this.isCredentialsNonExpired;
    }

    @Override
    public boolean isEnabled() {
        return this.isEnabled;
    }
}
