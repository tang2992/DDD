package com.tangkf.ddd.oopcargo.controller;

import com.tangkf.ddd.oopcargo.entity.CarrierMovement;
import com.tangkf.ddd.oopcargo.entity.Location;
import com.tangkf.ddd.oopcargo.service.ICarrierMovementService;
import com.tangkf.ddd.oopcargo.service.ILocationService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author tangkf
 * @since 2019-10-22
 */
@RestController
@RequestMapping("/routing")
public class LocationController {
    @Resource
    private ILocationService locationService;
    @Resource
    private ICarrierMovementService carrierMovementService;

    @RequestMapping(value = "/location", method = RequestMethod.GET)
    public List<Location> locations() {
        return locationService.list();
    }

    @RequestMapping(value = "/carrier", method = RequestMethod.GET)
    public List<CarrierMovement> carriers() {
        return carrierMovementService.list();
    }
}
