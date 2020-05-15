package com.beidou.bean;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@EnableUserBean
public class ApplicationTest {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(ApplicationTest.class);
        User user = ctx.getBean(User.class);
        System.out.println(user);

    }

}
