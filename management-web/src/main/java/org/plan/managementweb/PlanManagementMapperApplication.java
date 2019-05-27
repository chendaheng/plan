package org.plan.managementweb;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@ComponentScan(basePackages = {"org.plan.managementservice",
        "org.plan.managementfacade",
        "org.plan.managementweb"})
@MapperScan({"org.material.managementservice.mapper"})
@EnableTransactionManagement(proxyTargetClass = true)
 @EnableEurekaClient
public class PlanManagementMapperApplication {

    public static void main (String[] args) {
        SpringApplication.run(PlanManagementMapperApplication.class, args);
    }
}

