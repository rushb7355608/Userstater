package com.example.userstater;

import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnClass(User.class)
@EnableConfigurationProperties(Userproperty.class)
public class Userconfig {
    public Userconfig() {
        System.out.println("Userconfig加载了");
    }

    @Bean
    @ConditionalOnMissingBean(User.class)
    public User user(Userproperty userproperty){
         User user =new User(userproperty.getAge(), userproperty.getName());
        return user;
    }
}
