package com.tangkf.ddd.oopcargo.controller;

import com.tangkf.ddd.oopcargo.entity.CarrierMovement;
import com.tangkf.ddd.oopcargo.service.ICarrierMovementService;
import com.tangkf.ddd.oopcargo.service.ILocationService;
import com.tangkf.ddd.oopcargo.vo.CarrierMovementVo;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
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
    @Resource
    private ILocationService locationService;

    @RequestMapping(value = "/routing/carrier", method = RequestMethod.GET)
    public List<CarrierMovementVo> carriers() {
        List<CarrierMovement> carrierMovements = carrierMovementService.list();

        List<CarrierMovementVo> carrierMovementVoList = new ArrayList<>();
        for (CarrierMovement cm : carrierMovements) {
            CarrierMovementVo cmv = assembleCarrierMovementVo(cm);
            carrierMovementVoList.add(cmv);
        }
        return carrierMovementVoList;
    }

    private CarrierMovementVo assembleCarrierMovementVo(CarrierMovement cm) {
        CarrierMovementVo carrierMovementVo = new CarrierMovementVo();
        BeanUtils.copyProperties(cm, carrierMovementVo);
        carrierMovementVo.setFromLocationName(locationService.getById(carrierMovementVo.getFromLocationCode()).getName());
        carrierMovementVo.setToLocationName(locationService.getById(carrierMovementVo.getToLocationCode()).getName());
        return carrierMovementVo;
    }
}
