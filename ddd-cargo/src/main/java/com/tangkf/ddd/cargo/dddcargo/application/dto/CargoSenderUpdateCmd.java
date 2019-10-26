package com.tangkf.ddd.cargo.dddcargo.application.dto;

import lombok.Data;

@Data
public class CargoSenderUpdateCmd {

    private String cargoId;

    private String senderPhone;

}
