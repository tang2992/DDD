package com.tangkf.ddd.cargo.dddcargo.infrastructure.db.converter;

import com.tangkf.ddd.cargo.dddcargo.domain.entity.HandlingEvent;
import com.tangkf.ddd.cargo.dddcargo.domain.enums.EventTypeEnum;
import com.tangkf.ddd.cargo.dddcargo.infrastructure.db.dataobject.HandlingEventDO;

public class HandlingEventConverter {

    public static HandlingEventDO serialize(HandlingEvent event) {
        HandlingEventDO target = new HandlingEventDO();
        target.setId(event.getId());
        target.setCargoId(event.getCargoId());
        target.setDatetime(event.getDatetime());
        target.setScheduleId(event.getScheduleId());
        target.setEventType(event.getEventType().index());
        return target;
    }

    public static HandlingEvent deserialize(HandlingEventDO handlingEventDO) {
        HandlingEvent target = new HandlingEvent(handlingEventDO.getId(),
                handlingEventDO.getCargoId(),
                EventTypeEnum.of(handlingEventDO.getEventType()), handlingEventDO.getScheduleId(), handlingEventDO.getDatetime());
        return target;
    }

}
