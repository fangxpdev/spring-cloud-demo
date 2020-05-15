package com.beidou.bean;

import org.springframework.context.annotation.Bean;

public class UserConfiguration {

    @Bean
    public User user() {
        User user = new User();
        user.setUserName("beidou");
        user.setAge(18);
        return user;
    }

}
