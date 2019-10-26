package com.tangkf.ddd.cargo.dddcargo.web.controller;

import com.tangkf.ddd.cargo.dddcargo.application.CargoService;
import com.tangkf.ddd.cargo.dddcargo.application.dto.CargoBookCmd;
import com.tangkf.ddd.cargo.dddcargo.application.dto.CargoDTO;
import com.tangkf.ddd.cargo.dddcargo.application.dto.CargoQueryByCustomerQry;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class CargoController {
    @Resource
    private CargoService cargoService;

    @RequestMapping(value = "/cargo", method = RequestMethod.GET)
    public List<CargoDTO> queryCargos(
            @RequestParam(value = "phone", required = false) String phone) {
        List<CargoDTO> cargoList;
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
}
