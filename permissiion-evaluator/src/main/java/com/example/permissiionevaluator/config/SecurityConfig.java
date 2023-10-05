package com.example.permissiionevaluator.config;

import com.example.permissiionevaluator.expression.DocumentPermissionEvaluter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.expression.method.DefaultMethodSecurityExpressionHandler;
import org.springframework.security.access.expression.method.MethodSecurityExpressionHandler;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.GlobalMethodSecurityConfiguration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableMethodSecurity
public class SecurityConfig  {

    private DocumentPermissionEvaluter documentPermissionEvaluter;
    @Bean
    public UserDetailsService userDetailsService(){
        var uds = new InMemoryUserDetailsManager();
        var user1 = User.withUsername("john")
                .password("12345")
                .roles("ADMIN")
                .build();
        var user2 = User.withUsername("mary")
                .password("1234")
                .roles("USER")
                .build();
        uds.createUser(user1);
        uds.createUser(user2);
        return uds;
    }

    public PasswordEncoder passwordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }
    @Bean
    public MethodSecurityExpressionHandler methodSecurityExpressionHandler(){
        var expressioHandler = new DefaultMethodSecurityExpressionHandler();
        expressioHandler.setPermissionEvaluator(documentPermissionEvaluter);
        return expressioHandler;
    }

}
