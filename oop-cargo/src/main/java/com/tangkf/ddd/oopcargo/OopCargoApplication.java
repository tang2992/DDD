package com.tangkf.ddd.oopcargo;

import com.google.common.eventbus.EventBus;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@MapperScan("com.tangkf.ddd.oopcargo.mapper")
public class OopCargoApplication {
    @Bean
    public EventBus configEvent() {
        EventBus eventBus = new EventBus();
        return eventBus;
    }

    public static void main(String[] args) {
        SpringApplication.run(OopCargoApplication.class, args);
    }

}
