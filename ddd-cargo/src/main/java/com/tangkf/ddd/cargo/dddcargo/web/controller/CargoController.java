package com.tangkf.ddd.cargo.dddcargo.web.controller;

import com.tangkf.ddd.cargo.dddcargo.application.CargoService;
import com.tangkf.ddd.cargo.dddcargo.application.dto.*;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class CargoController {
    @Resource
    private CargoService cargoService;

    @RequestMapping(value = "/cargo", method = RequestMethod.GET)
    public List<CargoVo> queryCargos(
            @RequestParam(value = "phone", required = false) String phone) {
        List<CargoVo> cargoList;
        if (!StringUtils.isEmpty(phone)) {
            CargoQueryByCustomerQry qry = new CargoQueryByCustomerQry();
            qry.setSenderPhone(phone);
            cargoList = cargoService.queryCargos(qry);
        } else {
            cargoList = cargoService.queryCargos();
        }

        return cargoList;
    }

    @RequestMapping(value = "/cargo", method = RequestMethod.POST)
    public void book(@RequestBody CargoBookCmd cmd) {
        cargoService.book(cmd);
    }

    @RequestMapping(value = "/cargo/{cargoId}", method = RequestMethod.GET)
    public CargoVo cargo(@PathVariable String cargoId) {
        return cargoService.getCargo(cargoId);
    }

    @RequestMapping(value = "/cargo/{cargoId}/sender", method = RequestMethod.PUT)
    public void modifySender(@PathVariable String cargoId,
                             @RequestBody CargoSenderUpdateCmd cmd) {
        cmd.setCargoId(cargoId);
        cargoService.updateCargoSender(cmd);
    }

    @RequestMapping(value = "/cargo/{cargoId}/delivery", method = RequestMethod.PUT)
    public void modifyDestinationLocationCode(@PathVariable String cargoId,
                                              @RequestBody CargoDeliveryUpdateCmd cmd) {
        cmd.setCargoId(cargoId);
        cargoService.updateCargoDelivery(cmd);
    }
}
