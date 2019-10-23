package com.tangkf.ddd.oopcargo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.tangkf.ddd.oopcargo.mapper")
public class OopCargoApplication {

    public static void main(String[] args) {
        SpringApplication.run(OopCargoApplication.class, args);
    }

}
