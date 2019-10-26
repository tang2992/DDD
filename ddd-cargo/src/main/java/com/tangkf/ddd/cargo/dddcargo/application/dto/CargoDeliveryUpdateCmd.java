package com.tangkf.ddd.cargo.dddcargo.application.dto;

import lombok.Data;

@Data
public class CargoDeliveryUpdateCmd {

    private String cargoId;

    private String destinationLocationCode;

}
