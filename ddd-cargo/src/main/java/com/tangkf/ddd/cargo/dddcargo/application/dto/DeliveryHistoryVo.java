package com.tangkf.ddd.cargo.dddcargo.application.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DeliveryHistoryVo {
    private CargoDTO cargo;

    List<HandlingEventVo> events;
}
