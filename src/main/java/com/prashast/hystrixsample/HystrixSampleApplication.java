package com.prashast.hystrixsample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

@SpringBootApplication
@EnableHystrix
public class HystrixSampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(HystrixSampleApplication.class, args);
	}
}
