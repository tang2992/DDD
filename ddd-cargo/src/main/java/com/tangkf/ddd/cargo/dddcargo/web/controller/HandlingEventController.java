package com.tangkf.ddd.cargo.dddcargo.web.controller;

import com.tangkf.ddd.cargo.dddcargo.application.CargoService;
import com.tangkf.ddd.cargo.dddcargo.application.HandlingEventService;
import com.tangkf.ddd.cargo.dddcargo.application.dto.DeliveryHistoryVo;
import com.tangkf.ddd.cargo.dddcargo.application.dto.HandlingEventAddCmd;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author tangkf
 * @since 2019-10-22
 */
@RestController
public class HandlingEventController {
    @Resource
    private HandlingEventService handlingEventService;
    @Resource
    private CargoService cargoService;

    @RequestMapping(value = "/event", method = RequestMethod.POST)
    public void addHandlingEvent(@RequestBody HandlingEventAddCmd cmd) {
        handlingEventService.save(cmd);
    }

    @RequestMapping(value = "/track/{cargoId}", method = RequestMethod.GET)
    public DeliveryHistoryVo query(@PathVariable String cargoId) {
        return cargoService.queryHistory(cargoId);

    }
}
