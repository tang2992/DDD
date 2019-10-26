package com.tangkf.ddd.cargo.dddcargo;

import com.google.common.eventbus.EventBus;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@MapperScan("com.tangkf.ddd.cargo.dddcargo.infrastructure.db.mapper")
public class DddCargoApplication {
    @Bean
    public EventBus configEvent() {
        EventBus eventBus = new EventBus();
        return eventBus;
    }

    public static void main(String[] args) {
        SpringApplication.run(DddCargoApplication.class, args);
    }

}
