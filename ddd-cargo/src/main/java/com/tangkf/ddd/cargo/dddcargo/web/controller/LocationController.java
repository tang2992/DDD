package com.tangkf.ddd.cargo.dddcargo.web.controller;

import com.tangkf.ddd.cargo.dddcargo.application.LocationService;
import com.tangkf.ddd.cargo.dddcargo.domain.entity.Location;
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
public class LocationController {
    @Resource
    private LocationService locationService;

    @RequestMapping(value = "/routing/location", method = RequestMethod.GET)
    public List<Location> locations() {
        return locationService.list();
    }

}
