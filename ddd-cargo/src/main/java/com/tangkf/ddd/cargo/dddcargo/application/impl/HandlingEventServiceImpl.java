package com.tangkf.ddd.cargo.dddcargo.application.impl;

import com.tangkf.ddd.cargo.dddcargo.application.HandlingEventService;
import com.tangkf.ddd.cargo.dddcargo.application.dto.HandlingEventAddCmd;
import com.tangkf.ddd.cargo.dddcargo.domain.entity.HandlingEvent;
import com.tangkf.ddd.cargo.dddcargo.domain.enums.EventTypeEnum;
import com.tangkf.ddd.cargo.dddcargo.domain.repository.HandlingEventRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class HandlingEventServiceImpl implements HandlingEventService {
    @Resource
    private HandlingEventRepository repository;

    @Override
    public void save(HandlingEventAddCmd cmd) {
        HandlingEvent he = new HandlingEvent();
        he.setCargoId(cmd.getCargoId());
        he.setScheduleId(cmd.getScheduleId());
        he.setDatetime(cmd.getDatetime());
        he.setEventType(EventTypeEnum.of(cmd.getEventType()));
        repository.save(he);
    }
}
