package com.tangkf.ddd.cargo.dddcargo.infrastructure.event.dto;

import com.tangkf.ddd.cargo.dddcargo.domain.entity.Cargo;
import lombok.Data;

@Data
public class CargoBookDomainEvent {
    private Cargo cargo;
}
