package com.tangkf.ddd.oopcargo.controller;

import com.tangkf.ddd.oopcargo.entity.CarrierMovement;
import com.tangkf.ddd.oopcargo.service.ICarrierMovementService;
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
public class CarrierMovementController {
    @Resource
    private ICarrierMovementService carrierMovementService;

    @RequestMapping(value = "/routing/carrier", method = RequestMethod.GET)
    public List<CarrierMovement> carriers() {
        return carrierMovementService.list();
    }
}
