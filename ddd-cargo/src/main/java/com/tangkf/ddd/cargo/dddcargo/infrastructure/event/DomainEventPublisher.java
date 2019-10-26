package com.tangkf.ddd.cargo.dddcargo.infrastructure.event;

public interface DomainEventPublisher {
    void publish(Object event);

}
