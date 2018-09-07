//package com.dome.security.controller;
//
//import org.springframework.security.access.ConfigAttribute;
//import org.springframework.security.access.SecurityConfig;
//import org.springframework.security.web.FilterInvocation;
//import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
//import org.springframework.stereotype.Component;
//
//import java.util.Collection;
//@Component
//public class UrlFilterInvocationSecurityMetadataSource implements FilterInvocationSecurityMetadataSource {
//
//
//    @Override
//    public Collection<ConfigAttribute> getAttributes(Object o) throws IllegalArgumentException {
//        //获取请求地址
//        String requestUrl = ((FilterInvocation) o).getRequestUrl();
//        if ("/login_p".equals(requestUrl)) {
//            return null;
//        }
//
//        //没有匹配上的资源，都是登录访问
//        return SecurityConfig.createList("ROLE_LOGIN");
//    }
//
//    @Override
//    public Collection<ConfigAttribute> getAllConfigAttributes() {
//        return null;
//    }
//
//    @Override
//    public boolean supports(Class<?> aClass) {
//        return FilterInvocation.class.isAssignableFrom(aClass);
//    }
//}
//
