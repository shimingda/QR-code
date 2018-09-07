//package com.dome.security.config;
//
//import com.dome.security.dome.User;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//
///**
// * Created by zhangwen@reconova.com on 2016/7/10.
// * 将当前用户注入 CreateBy 字段
// */
//public class SecurityAuditorAware  {
//
//    public User getCurrentAuditor() {
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        if (authentication == null) {
//            return null;
//        }
//        User user = null;
//        try {
//            user = (User) authentication.getPrincipal();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        return user;
//    }
//}
