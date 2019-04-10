package com.hqk.serviceprovision.util;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(1) //里面的值越小启动越早
public class After implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {

        System.out.println("这个将在系统运行的时候初始化： " +
                "会在所有 Spring Beans 都初始化之后，SpringApplication.run() 之前执行");


    }
}
