package com.tangkf.ddd.cargo.dddcargo.infrastructure.db.converter;

import com.tangkf.ddd.cargo.dddcargo.domain.entity.Cargo;
import com.tangkf.ddd.cargo.dddcargo.domain.valueobject.DeliverySpecification;
import com.tangkf.ddd.cargo.dddcargo.infrastructure.db.dataobject.CargoDO;

import java.time.LocalDateTime;

public class CargoConverter {

    public static CargoDO serialize(Cargo cargo) {
        CargoDO target = new CargoDO();
        target.setId(cargo.getId());
        target.setSenderPhone(cargo.getSenderPhone());
        target.setDescription(cargo.getDescription());
        DeliverySpecification delivery = cargo.getDeliverySpecification();
        if (delivery != null) {
            target.setDestinationLocationCode(delivery.getDestinationLocationCode());
            target.setOriginLocationCode(delivery.getOriginLocationCode());
        }
        target.setCreatedAt(LocalDateTime.now());
        return target;
    }

    public static Cargo deserialize(CargoDO cargo) {
        Cargo target = new Cargo(cargo.getId(), cargo.getSenderPhone(), cargo.getDescription(),
                new DeliverySpecification(cargo.getOriginLocationCode(),
                        cargo.getDestinationLocationCode()));
        return target;
    }

}
