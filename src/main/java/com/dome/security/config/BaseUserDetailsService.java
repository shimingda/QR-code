package com.dome.security.config;

import com.dome.security.dome.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;

public class BaseUserDetailsService implements UserDetailsService {
    @Autowired
    BaseUserDetailsService baseUserDetailsService;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("用户的用户名"+username);
        String password =passwordEncoder.encode("123456");
        User user=new User();
        user.setUsername(username);
        user.setPassword(password);

        return user;
    }
}
