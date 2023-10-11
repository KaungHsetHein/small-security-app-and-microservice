package com.example.springsecuritymasterfilterdemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(securedEnabled = true,jsr250Enabled = true)
public class SecurityConfig {
    @Bean
    public UserDetailsService userDetailsService(){
        var manager=new InMemoryUserDetailsManager();
        var user1= User.withUsername("john")
                        .password("john")
                                .roles("SUPER_ADMIN")
                                        .build();
        var user2=User.withUsername("emma")
                        .password("emma")
                                .roles("EMPLOYEE_ADMIN")
                                        .build();
        var user3=User.withUsername("lucas")
                        .password("lucas")
                                .roles("DEPARTMENT_READ","DEPARTMENT_WRITE")
                                        .build();
        var user4=User.withUsername("richard")
                        .password("richard")
                                .roles("CUSTOMER_READ")
                                        .build();
        var user5=User.withUsername("james")
                        .password("james")
                                .roles()
                                        .build();
        manager.createUser(user1);
        manager.createUser(user2);
        manager.createUser(user3);
        manager.createUser(user4);
        manager.createUser(user5);
        return manager;


    }
    @Bean
    public PasswordEncoder passwordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http)
            throws Throwable{
        http.formLogin(c->c.loginPage("/login")
                .failureUrl("/login-error").permitAll());
        http.logout(c->c.logoutUrl("/logout")
                .logoutSuccessUrl("/login").permitAll());
        http.authorizeHttpRequests(c->{
                c.requestMatchers("/bootstrap/**","/").permitAll()
                        .anyRequest()
                        .authenticated();

        });
        return http.build();
    }
}
