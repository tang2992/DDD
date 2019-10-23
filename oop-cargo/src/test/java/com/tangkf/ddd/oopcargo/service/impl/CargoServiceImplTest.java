package com.tangkf.ddd.oopcargo.service.impl;

import com.tangkf.ddd.oopcargo.entity.Cargo;
import com.tangkf.ddd.oopcargo.service.ICargoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.time.LocalDateTime;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CargoServiceImplTest {
    @Resource
    private ICargoService cargoService;

    @Test
    public void book() {
        Cargo cargo = Cargo.builder()
                .senderPhone("125369")
                .destinationLocationCode("HZ")
                .originLocationCode("BJ")
                .description("测试")
                .createdAt(LocalDateTime.now())
                .build();
        cargoService.book(cargo);
    }
}