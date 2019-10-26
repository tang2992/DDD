package com.tangkf.ddd.cargo.dddcargo.application;

import com.tangkf.ddd.cargo.dddcargo.application.dto.CarrierMovementVo;

import java.util.List;

public interface CarrierMovementService {
    List<CarrierMovementVo> selectAll();
}
