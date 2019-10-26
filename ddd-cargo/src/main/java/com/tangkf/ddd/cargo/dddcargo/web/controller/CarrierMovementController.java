package com.tangkf.ddd.cargo.dddcargo.web.controller;

import com.tangkf.ddd.cargo.dddcargo.application.CarrierMovementService;
import com.tangkf.ddd.cargo.dddcargo.application.dto.CarrierMovementVo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class CarrierMovementController {
    @Resource
    private CarrierMovementService carrierMovementService;

    @RequestMapping(value = "/routing/carrier", method = RequestMethod.GET)
    public List<CarrierMovementVo> carriers() {
        return carrierMovementService.selectAll();

    }
}
