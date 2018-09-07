package com.dome.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.web.session.SessionInformationExpiredStrategy;



@Configuration
public class SecurityBeanConfig {
    @Autowired
    private SecurityProperty securityProperty;
    @Bean
    public SessionInformationExpiredStrategy sessionInformationExpiredStrategy(){
        return new MerryyouExpiredSessionStrategy(securityProperty.getSession().getSessionInvalidUrl());
    }

}
