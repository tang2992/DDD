package com.tangkf.ddd.cargo.dddcargo.application.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CargoDTO {
    private String id;

    private String senderPhone;

    private String description;

    private String originLocationCode;

    private String destinationLocationCode;
    private String originLocationName;
    private String destinationLocationName;
}
