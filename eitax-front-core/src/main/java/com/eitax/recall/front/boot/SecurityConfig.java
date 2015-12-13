package com.eitax.recall.front.boot;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configurers.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.ldap.authentication.ad.ActiveDirectoryLdapAuthenticationProvider;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebMvcSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/webjars/**", "/css/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/loginForm").permitAll()
                .anyRequest().authenticated();
        http.formLogin().loginProcessingUrl("/login")
                .loginPage("/loginForm")
                .failureUrl("/loginForm?error")
                .defaultSuccessUrl("/customers", true)
                .usernameParameter("username").passwordParameter("password");
        http.logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout**"))
                .logoutSuccessUrl("/loginForm");
    }

//    @Configuration
//    static class AuthenticationConfiguration extends GlobalAuthenticationConfigurerAdapter {
//        @Autowired
//        UserDetailsService userDetailsService;
//
//        @Bean
//        PasswordEncoder passwordEncoder() {
//            return new BCryptPasswordEncoder();
//        }
//
//        @Override
//        public void init(AuthenticationManagerBuilder auth) throws Exception {
//            auth.userDetailsService(userDetailsService)
//                    .passwordEncoder(passwordEncoder());
//        }
//    }

    @Override
    protected void configure(AuthenticationManagerBuilder authManagerBuilder) throws Exception {
         authManagerBuilder.authenticationProvider(activeDirectoryLdapAuthenticationProvider());
//         .userDetailsService(userDetailsService());
    }

//    @Bean
//    public AuthenticationManager authenticationManager() {
//         return new ProviderManager(Arrays.asList(activeDirectoryLdapAuthenticationProvider()));
//    }
    @Bean
    public AuthenticationProvider activeDirectoryLdapAuthenticationProvider() {
         ActiveDirectoryLdapAuthenticationProvider provider = new ActiveDirectoryLdapAuthenticationProvider("mydomain.local", "ldap://192.168.0.61:389");
         provider.setConvertSubErrorCodesToExceptions(true);
         provider.setUseAuthenticationRequestCredentials(true);
         return provider;
    }

}
