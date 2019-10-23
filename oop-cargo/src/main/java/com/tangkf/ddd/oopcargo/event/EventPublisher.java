package com.tangkf.ddd.oopcargo.event;

import com.google.common.eventbus.EventBus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EventPublisher {
    @Autowired
    private EventBus eventBus;

    public void publish(Object event) {
        eventBus.post(event);
    }
}
