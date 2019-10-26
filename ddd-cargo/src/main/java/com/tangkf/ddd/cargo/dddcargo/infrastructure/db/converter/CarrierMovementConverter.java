package com.tangkf.ddd.cargo.dddcargo.infrastructure.db.converter;

import com.tangkf.ddd.cargo.dddcargo.domain.entity.CarrierMovement;
import com.tangkf.ddd.cargo.dddcargo.infrastructure.db.dataobject.CarrierMovementDO;
import org.springframework.beans.BeanUtils;

import java.time.LocalDateTime;

public class CarrierMovementConverter {

    public static CarrierMovementDO serialize(CarrierMovement movement) {
        CarrierMovementDO target = new CarrierMovementDO();
        BeanUtils.copyProperties(movement, target);
        target.setCreatedAt(LocalDateTime.now());
        return target;
    }

    public static CarrierMovement deserialize(CarrierMovementDO locationDO) {
        CarrierMovement target = new CarrierMovement();
        BeanUtils.copyProperties(locationDO, target);
        return target;
    }

}
