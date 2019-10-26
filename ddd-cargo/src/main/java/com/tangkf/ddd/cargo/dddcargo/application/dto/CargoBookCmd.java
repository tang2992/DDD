package com.tangkf.ddd.cargo.dddcargo.application.dto;

import lombok.Data;

@Data
public class CargoBookCmd {
    private String senderPhone;
    private String description;
    private String originLocationCode;
    private String destinationLocationCode;
}
