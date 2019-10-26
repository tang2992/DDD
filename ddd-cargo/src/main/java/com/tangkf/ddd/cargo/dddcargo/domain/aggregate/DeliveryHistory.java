package com.tangkf.ddd.cargo.dddcargo.domain.aggregate;

import com.tangkf.ddd.cargo.dddcargo.domain.entity.Cargo;
import com.tangkf.ddd.cargo.dddcargo.domain.entity.HandlingEvent;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DeliveryHistory {
    private Cargo cargo;

    List<HandlingEvent> events;
}
