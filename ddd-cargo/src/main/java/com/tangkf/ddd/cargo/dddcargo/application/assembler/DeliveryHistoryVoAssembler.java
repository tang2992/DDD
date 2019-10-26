package com.tangkf.ddd.cargo.dddcargo.application.assembler;

import com.tangkf.ddd.cargo.dddcargo.application.dto.CargoVo;
import com.tangkf.ddd.cargo.dddcargo.application.dto.DeliveryHistoryVo;
import com.tangkf.ddd.cargo.dddcargo.application.dto.HandlingEventVo;
import com.tangkf.ddd.cargo.dddcargo.domain.aggregate.DeliveryHistory;
import com.tangkf.ddd.cargo.dddcargo.domain.entity.CarrierMovement;
import com.tangkf.ddd.cargo.dddcargo.domain.entity.HandlingEvent;
import com.tangkf.ddd.cargo.dddcargo.domain.repository.CarrierMovementRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

@Component
public class DeliveryHistoryVoAssembler implements Function<DeliveryHistory, DeliveryHistoryVo> {

    @Autowired
    private CargoDTOAssembler cargoDTOAssembler;
    @Autowired
    private CarrierMovementVoAssembler carrierMovementVoAssembler;
    @Autowired
    private CarrierMovementRepository carrierMovementRepository;

    @Override
    public DeliveryHistoryVo apply(DeliveryHistory t) {
        DeliveryHistoryVo deliveryHistoryVo = new DeliveryHistoryVo();

        CargoVo cargoVo = cargoDTOAssembler.apply(t.getCargo());
        deliveryHistoryVo.setCargo(cargoVo);

        List<HandlingEventVo> eventVoList = new ArrayList<>();
        List<HandlingEvent> events = t.getEvents();
        for (HandlingEvent he : events) {
            HandlingEventVo handlingEventVo = new HandlingEventVo();
            BeanUtils.copyProperties(he, handlingEventVo);
            CarrierMovement carrierMovement = carrierMovementRepository.getById(he.getScheduleId());
            handlingEventVo.setEventType(he.getEventType().name());
            handlingEventVo.setCarrierMovement(carrierMovementVoAssembler.apply(carrierMovement));
            eventVoList.add(handlingEventVo);
        }
        deliveryHistoryVo.setEvents(eventVoList);

        return deliveryHistoryVo;
    }
}
