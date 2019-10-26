package com.tangkf.ddd.cargo.dddcargo.application.assembler;

import com.tangkf.ddd.cargo.dddcargo.application.dto.CarrierMovementVo;
import com.tangkf.ddd.cargo.dddcargo.domain.entity.CarrierMovement;
import com.tangkf.ddd.cargo.dddcargo.domain.entity.Location;
import com.tangkf.ddd.cargo.dddcargo.domain.repository.LocationRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class CarrierMovementVoAssembler implements Function<CarrierMovement, CarrierMovementVo> {

    @Autowired
    private LocationRepository repository;

    @Override
    public CarrierMovementVo apply(CarrierMovement t) {
        if (t == null) {
            return null;
        }
        CarrierMovementVo target = new CarrierMovementVo();
        BeanUtils.copyProperties(t, target);
        Location fromLocation = repository.getById(t.getFromLocationCode());
        target.setFromLocationName(fromLocation.getName());
        Location toLocation = repository.getById(t.getToLocationCode());
        target.setToLocationName(toLocation.getName());
        return target;
    }

}