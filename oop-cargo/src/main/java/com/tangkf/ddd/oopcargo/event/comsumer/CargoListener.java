package com.tangkf.ddd.oopcargo.event.comsumer;

import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;
import com.tangkf.ddd.oopcargo.entity.Cargo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Slf4j
@Component
public class CargoListener {

    @Autowired
    private EventBus eventBus;
    
    @PostConstruct
    public void init(){
        eventBus.register(this);
    }

    @Subscribe
    public void recordCargoBook(Cargo event) {
        // invoke application service or domain service
        System.out.println("CargoListener: recordCargoBook......");
    }
}
