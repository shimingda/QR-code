package com.dome.security.provider;

import com.dome.security.dome.User;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.Collection;

/**
 * 认证
 * Created by zhangwen@reconova.com on 2016/12/15.
 */
@Component
public class AuthenticateProvider extends DaoAuthenticationProvider {


    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String password = (String) authentication.getCredentials();
        User user=null;
        if (user == null) {
            throw new BadCredentialsException("用户不存在");
        }
//        Object salt = null;
//
//        logger.debug("validate:" + username + "###" + password);
//        boolean passwordValid = false;
//        if (!passwordValid) {
//            throw new BadCredentialsException("密码错误");
//        }
//
//        if (!user.isEnabled()) {
//            throw new DisabledException("用户被禁用");
//        }
//
        Collection<? extends GrantedAuthority> grantedAuthorities = user.getAuthorities();
        return new UsernamePasswordAuthenticationToken(user, password, grantedAuthorities);
    }

}
