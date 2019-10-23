package com.tangkf.ddd.oopcargo.vo;

import com.tangkf.ddd.oopcargo.entity.HandlingEvent;
import lombok.Data;

@Data
public class HandlingEventVo extends HandlingEvent {
    private String eventType;

    private CarrierMovementVo carrierMovement;
}
