package com.tangkf.ddd.oopcargo.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.tangkf.ddd.oopcargo.entity.Cargo;
import com.tangkf.ddd.oopcargo.service.ICargoService;
import com.tangkf.ddd.oopcargo.service.ILocationService;
import com.tangkf.ddd.oopcargo.vo.CargoVo;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
@RestController
@RequestMapping("/cargo")
public class CargoController{
    @Resource
    private ICargoService cargoService;
    @Resource
    private ILocationService locationService;

    @RequestMapping(method = RequestMethod.GET)
    public List<CargoVo> queryCargos(
            @RequestParam(value = "phone", required = false) String phone) {
        List<Cargo> cargoList;
        if (!StringUtils.isEmpty(phone)) {
            QueryWrapper<Cargo> qry = new QueryWrapper();
            qry.eq("sender_phone", phone);
            cargoList = cargoService.list(qry);
        } else {
            cargoList = cargoService.list();
        }

        // TODO 这里还要对对象做转换，是地区代码转换为地区名称
        List<CargoVo> cargoVoList = new ArrayList<>();
        for (Cargo cargo : cargoList) {
            CargoVo cargoVo = assemblerCargoVo(cargo);
            cargoVoList.add(cargoVo);
        }

        return cargoVoList;
    }

    private CargoVo assemblerCargoVo(Cargo cargo) {
        CargoVo cargoVo = new CargoVo();
        BeanUtils.copyProperties(cargo, cargoVo);
        cargoVo.setOriginLocationName(locationService.getById(cargo.getOriginLocationCode()).getName());
        cargoVo.setDestinationLocationName(locationService.getById(cargo.getDestinationLocationCode()).getName());
        return cargoVo;
    }

    @RequestMapping(method = RequestMethod.POST)
    public void book(@RequestBody Cargo cargo) {
        cargoService.book(cargo);
    }

    @RequestMapping(value = "/{cargoId}", method = RequestMethod.GET)
    public CargoVo cargo(@PathVariable String cargoId) {
        return assemblerCargoVo(cargoService.getById(cargoId));
    }

    @RequestMapping(value = "/{cargoId}/sender", method = RequestMethod.PUT)
    public void modifySender(@PathVariable String cargoId,
                             @RequestBody Cargo cmd) {
        cmd.setId(cargoId);
        cargoService.updateById(cmd);
    }

    @RequestMapping(value = "/{cargoId}/delivery", method = RequestMethod.PUT)
    public void modifydestinationLocationCode(@PathVariable String cargoId,
                                              @RequestBody Cargo cmd) {
        cmd.setId(cargoId);
        cargoService.updateById(cmd);
    }
}
