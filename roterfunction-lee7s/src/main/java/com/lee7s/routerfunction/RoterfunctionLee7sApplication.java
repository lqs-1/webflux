package com.lee7s.routerfunction;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

// 开启mongodb的jpa

@EnableReactiveMongoRepositories
@SpringBootApplication
public class RoterfunctionLee7sApplication {

    public static void main(String[] args) {
        SpringApplication.run(RoterfunctionLee7sApplication.class, args);
    }

}
