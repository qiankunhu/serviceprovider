package com.hqk.serviceprovision;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableEurekaClient
//@EnableDiscoveryClient
@MapperScan("com.hqk.serviceprovision.dao")
@EnableScheduling//定时任务注解
@EnableFeignClients //启用feign进行远程调用
public class ServiceprovisionApplication {

	public static void main(String[] args) {

		System.out.println("程序启动 start");
		SpringApplication.run(ServiceprovisionApplication.class, args);
		System.out.println("程序启动 end");
	}
}
