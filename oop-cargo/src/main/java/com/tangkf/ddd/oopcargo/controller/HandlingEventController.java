package com.tangkf.ddd.oopcargo.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.tangkf.ddd.oopcargo.entity.Cargo;
import com.tangkf.ddd.oopcargo.entity.CarrierMovement;
import com.tangkf.ddd.oopcargo.entity.HandlingEvent;
import com.tangkf.ddd.oopcargo.enums.EventTypeEnum;
import com.tangkf.ddd.oopcargo.service.ICargoService;
import com.tangkf.ddd.oopcargo.service.ICarrierMovementService;
import com.tangkf.ddd.oopcargo.service.IHandlingEventService;
import com.tangkf.ddd.oopcargo.service.ILocationService;
import com.tangkf.ddd.oopcargo.vo.CargoHandlingEventVo;
import com.tangkf.ddd.oopcargo.vo.CargoVo;
import com.tangkf.ddd.oopcargo.vo.CarrierMovementVo;
import com.tangkf.ddd.oopcargo.vo.HandlingEventVo;
import org.springframework.beans.BeanUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

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
public class HandlingEventController {
    @Resource
    private IHandlingEventService handlingEventService;
    @Resource
    private ICargoService cargoService;
    @Resource
    private ILocationService locationService;
    @Resource
    private ICarrierMovementService carrierMovementService;

    @RequestMapping(value = "/event", method = RequestMethod.POST)
    public void addHandlingEvent(@RequestBody HandlingEvent cmd) {
        handlingEventService.save(cmd);
    }

    @RequestMapping(value = "/track/{cargoId}", method = RequestMethod.GET)
    public CargoHandlingEventVo query(@PathVariable String cargoId) {
        Cargo cargo = cargoService.getById(cargoId);

        QueryWrapper<HandlingEvent> qry = new QueryWrapper<>();
        qry.eq("cargo_id", cargoId);
        qry.orderByDesc("datetime");
        List<HandlingEvent> handlingEvents = handlingEventService.list(qry);

        List<HandlingEventVo> handlingEventVoList = new ArrayList<>();
        for (HandlingEvent event : handlingEvents) {
            HandlingEventVo eventVo = new HandlingEventVo();
            BeanUtils.copyProperties(event, eventVo);
            eventVo.setEventType(EventTypeEnum.of(eventVo.getEventtype()).name());
            if (!StringUtils.isEmpty(event.getScheduleId())) {
                CarrierMovement cm = carrierMovementService.getById(event.getScheduleId());
                CarrierMovementVo carrierMovementVo = assembleCarrierMovementVo(cm);

                eventVo.setCarrierMovement(carrierMovementVo);
            }

            handlingEventVoList.add(eventVo);
        }

        return new CargoHandlingEventVo(assemblerCargoVo(cargo), handlingEventVoList);
    }

    private CarrierMovementVo assembleCarrierMovementVo(CarrierMovement cm) {
        CarrierMovementVo carrierMovementVo = new CarrierMovementVo();
        BeanUtils.copyProperties(cm, carrierMovementVo);
        carrierMovementVo.setFromLocationName(locationService.getById(carrierMovementVo.getFromLocationCode()).getName());
        carrierMovementVo.setToLocationName(locationService.getById(carrierMovementVo.getToLocationCode()).getName());
        return carrierMovementVo;
    }


    private CargoVo assemblerCargoVo(Cargo cargo) {
        CargoVo cargoVo = new CargoVo();
        BeanUtils.copyProperties(cargo, cargoVo);
        cargoVo.setOriginLocationName(locationService.getById(cargo.getOriginLocationCode()).getName());
        cargoVo.setDestinationLocationName(locationService.getById(cargo.getDestinationLocationCode()).getName());
        return cargoVo;
    }
}
