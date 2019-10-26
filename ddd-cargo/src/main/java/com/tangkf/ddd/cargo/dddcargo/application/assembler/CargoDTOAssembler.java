package com.tangkf.ddd.cargo.dddcargo.application.assembler;

import com.tangkf.ddd.cargo.dddcargo.application.dto.CargoDTO;
import com.tangkf.ddd.cargo.dddcargo.domain.entity.Cargo;
import com.tangkf.ddd.cargo.dddcargo.domain.entity.Location;
import com.tangkf.ddd.cargo.dddcargo.domain.repository.LocationRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class CargoDTOAssembler implements Function<Cargo, CargoDTO> {

    @Autowired
    private LocationRepository repository;

    @Override
    public CargoDTO apply(Cargo t) {
        CargoDTO target = new CargoDTO();
        BeanUtils.copyProperties(t, target);
        Location select = repository.getById(t.getDeliverySpecification().getOriginLocationCode());
        target.setOriginLocationName(select.getName());
        select = repository.getById(t.getDeliverySpecification().getDestinationLocationCode());
        target.setDestinationLocationName(select.getName());
        return target;
    }

}
