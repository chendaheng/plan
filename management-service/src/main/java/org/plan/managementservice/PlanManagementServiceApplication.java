package org.plan.managementservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"org.plan.managementservice",
        "org.plan.managementfacade"})
public class PlanManagementServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(PlanManagementServiceApplication.class, args);
    }
}
