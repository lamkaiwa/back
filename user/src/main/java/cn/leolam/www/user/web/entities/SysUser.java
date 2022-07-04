package cn.leolam.www.user.web.entities;

import lombok.Data;

@Data
public class SysUser {
    String username;
    String password;
    String phone;
    String email;
    Integer isAccountNonExpired;
    Integer isAccountNonLocked;
    Integer isCredentialsNonExpired;
    Integer isEnabled;
    String authoritiesString;
    Long usersId;
}
