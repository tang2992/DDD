package com.tangkf.ddd.oopcargo.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CargoHandlingEventVo {
    private CargoVo cargo;

    List<HandlingEventVo> events;
}
