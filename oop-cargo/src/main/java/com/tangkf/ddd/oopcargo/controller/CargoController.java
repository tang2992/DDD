package com.tangkf.ddd.oopcargo.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.tangkf.ddd.oopcargo.entity.Cargo;
import com.tangkf.ddd.oopcargo.service.ICargoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

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
@Slf4j
@RestController
@RequestMapping("/cargo")
public class CargoController{
    @Resource
    private ICargoService cargoService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Cargo> queryCargos(
            @RequestParam(value = "phone", required = false) String phone) {
        if (!StringUtils.isEmpty(phone)) {
            QueryWrapper<Cargo> qry = new QueryWrapper();
            qry.eq("sender_phone", phone);
            return cargoService.list(qry);
        }
        return cargoService.list();

        // TODO 这里还要对对象做转换，是地区代码转换为地区名称
    }

    @RequestMapping(method = RequestMethod.POST)
    public void book(@RequestBody Cargo cargo) {
        cargoService.book(cargo);
    }

}
