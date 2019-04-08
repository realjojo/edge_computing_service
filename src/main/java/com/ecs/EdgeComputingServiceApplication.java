package com.ecs;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class, HibernateJpaAutoConfiguration.class})
@MapperScan("com.ecs.mapper")
@EnableAsync
public class EdgeComputingServiceApplication {

    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger(EdgeComputingServiceApplication.class);
        logger.debug("start application");
        SpringApplication.run(EdgeComputingServiceApplication.class, args);
    }
}
