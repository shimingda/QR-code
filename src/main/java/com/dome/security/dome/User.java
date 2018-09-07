package com.dome.security.dome;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.Collection;

/**
 *
 * Created by baymax on 2016/6/24.
 */

public class User  implements UserDetails, Serializable {

    private static final Logger logger = LoggerFactory.getLogger(User.class);

    private static final long serialVersionUID = -383540476492602568L;

    private Long id;

    /**
     * 用户名，登录名
     */

    private String username;

    /**
     * 密码 bcrypt加密
     */

    private String password;

    /**
     * 联系电话
     */

    private String telephone;

    /**
     * 邮箱
     */

    private String email;

    /**
     * 是否可用
     */

    private boolean enabled;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
