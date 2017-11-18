package com.ccq.membercenter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

@SpringBootApplication
@ComponentScan(basePackages = { "com.ccq.membercenter" })
@EnableDiscoveryClient
@EnableRedisHttpSession
public class MemberCenterApplication {

	public static void main(String[] args) {
		SpringApplication.run(MemberCenterApplication.class, args);
	}
}
