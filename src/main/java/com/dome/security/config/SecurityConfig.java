package com.dome.security.config;


import com.dome.security.provider.AuthenticateProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.session.SessionInformationExpiredStrategy;

/**
 *  安全配置文件
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, proxyTargetClass = true, securedEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private SecurityProperty securityProperty;
    @Autowired
    private SessionInformationExpiredStrategy sessionInformationExpiredStrategy;
    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private PasswordEncoder passwordEncoder;
//    @Autowired
//    UrlFilterInvocationSecurityMetadataSource urlFilterInvocationSecurityMetadataSource;
//
//    @Autowired
//    UrlAccessDecisionManager urlAccessDecisionManager;


    @Autowired
    public void globalConfigure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticateProvider());
    }
//    @Autowired
//    private AuthenticationSuccessHandler merryyouLoginSuccessHandler;
//    @Autowired
//    private AuthenticationFailureHandler merryyouAuthenticationfailureHandler;

    /**
     * 配置密码
     * @return
     */
//    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(this.userDetailsService);
//    }

    @Bean
    public AuthenticateProvider authenticateProvider() {
        AuthenticateProvider provider = new AuthenticateProvider();
        provider.setUserDetailsService(userDetailsService);
        provider.setPasswordEncoder(passwordEncoder());
        return provider;
    }
    @Bean
    public UserDetailsService userDetailsService(){
        return new BaseUserDetailsService();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    // 定义认证用户信息获取来源，密码效验规则



    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        System.out.println("验证");
        auth.inMemoryAuthentication().withUser("bill").password("abc123").roles("USER");
        auth.inMemoryAuthentication().withUser("admin").password("root123").roles("ADMIN");
        auth.inMemoryAuthentication().withUser("dba").password("root123").roles("ADMIN","DBA");
        //在内存中创建一个用户
    }
    /**
     * 配置用户管理
     * @param auth
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
    }

    /**
     * 配置访问http内容
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        //        登录
        http
                .formLogin()
                .loginPage("/login")
                .loginProcessingUrl("/user/test")
//                .usernameParameter("username")
//               .passwordParameter("password")
                .permitAll();//使用表单登录，不再使用默认httpBasic方式

//关闭csrf 防止循环定向
        http.csrf().disable();


        //url拦截
        http
                .authorizeRequests()//定义哪些url需要保护，哪些url不需要保护
                .antMatchers("/","message").permitAll()//定义不需要认证就可以访问
                .antMatchers("/test").permitAll()
         ;
//                .anyRequest().authenticated() //其他所有资源都需要认证，登陆后访问
//                .antMatchers("/user/**").hasAuthority("ADMIN") //登陆后之后拥有“ADMIN”权限才可以访问/hello方法，否则系统会出现“403”权限不足的提示


//                .successHandler(merryyouLoginSuccessHandler)//登录成功处理器，返回JSON

//     post请求   authorizeRequests()
//                .withObjectPostProcessor(new ObjectPostProcessor<FilterSecurityInterceptor>() {
//                    @Override
//                    public <O extends FilterSecurityInterceptor> O postProcess(O o) {
//                        o.setSecurityMetadataSource(urlFilterInvocationSecurityMetadataSource);
//                        o.setAccessDecisionManager(urlAccessDecisionManager);
//                        return o;
//                    }
//                }).and()
//                .failureHandler(merryyouAuthenticationfailureHandler);//登录失败处理器;
        // 自定义注销
        http.logout().logoutUrl("/logout").logoutSuccessUrl("/login")
                .invalidateHttpSession(true);
        // session管理
        http.sessionManagement().sessionFixation().changeSessionId()
                .invalidSessionUrl("/session/invalid")
                .maximumSessions(1)//最大session并发数量1
                .maxSessionsPreventsLogin(true)//之后的登录踢掉之前的登录
                .expiredSessionStrategy(sessionInformationExpiredStrategy).expiredUrl("/");
        // RemeberMe
        http.rememberMe()
                .key("webmvc#FD637E6D9C0F1A5A67082AF56CE32485")
                //设置cookie有效期
                .tokenValiditySeconds(60 * 60 * 24 * 7);

        http .requestCache()
                .requestCache(new HttpSessionRequestCache());
    }
    /**
     * DataEntity审核组件
     *
     * @return
     */
//    @Bean
//    public SecurityAuditorAware auditorProvider() {
//        return new SecurityAuditorAware();
//    }

}
