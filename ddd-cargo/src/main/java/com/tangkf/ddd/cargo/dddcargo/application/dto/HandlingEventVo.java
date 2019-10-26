package com.tangkf.ddd.cargo.dddcargo.application.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class HandlingEventVo {
    private String id;

    private String cargoId;

    private String eventType;


    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date datetime;

    private CarrierMovementVo carrierMovement;
}
