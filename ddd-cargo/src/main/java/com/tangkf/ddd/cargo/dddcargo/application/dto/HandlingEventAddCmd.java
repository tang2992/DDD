package com.tangkf.ddd.cargo.dddcargo.application.dto;

import lombok.Data;

import java.util.Date;

@Data
public class HandlingEventAddCmd {
    private String cargoId;
    /**
     * 0:receive 1:load 2:unload 3:end
     */
    private int eventType;

    private Date datetime;
    private String scheduleId;
}
