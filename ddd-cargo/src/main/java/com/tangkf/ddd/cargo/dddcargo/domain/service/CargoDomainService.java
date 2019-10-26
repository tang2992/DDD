package com.tangkf.ddd.cargo.dddcargo.domain.service;

import com.tangkf.ddd.cargo.dddcargo.domain.aggregate.DeliveryHistory;
import com.tangkf.ddd.cargo.dddcargo.domain.entity.Cargo;
import com.tangkf.ddd.cargo.dddcargo.domain.entity.HandlingEvent;
import com.tangkf.ddd.cargo.dddcargo.domain.repository.CargoRepository;
import com.tangkf.ddd.cargo.dddcargo.domain.repository.HandlingEventRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CargoDomainService {
    @Resource
    private CargoRepository cargoRepository;

    @Resource
    private HandlingEventRepository handlingEventRepository;

    public DeliveryHistory queryHistory(String cargoId) {
        Cargo cargo = cargoRepository.getById(cargoId);

        DeliveryHistory deliveryHistory = new DeliveryHistory();
        deliveryHistory.setCargo(cargo);
        List<HandlingEvent> handlingEvents = handlingEventRepository.selectByCargo(cargoId);
        deliveryHistory.setEvents(handlingEvents);

        return deliveryHistory;
    }
}
