package com.example.smallsecurityappdemo;

import com.example.smallsecurityappdemo.dao.RoleDao;
import com.example.smallsecurityappdemo.entity.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@RequiredArgsConstructor
public class SmallSecurityAppDemoApplication {
    private final RoleDao roleDao;
    //@Bean
    public ApplicationRunner runner(){
        return r->{
            Role role1=new Role();
            role1.setRoleName("ROLE_NAME");
            Role role2=new Role("ROLE_ADMIN");
            roleDao.save(role1);
            roleDao.save(role2);
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(SmallSecurityAppDemoApplication.class, args);
    }

}
