package com.tangkf.ddd.oopcargo.controller;

import com.tangkf.ddd.oopcargo.entity.HandlingEvent;
import com.tangkf.ddd.oopcargo.service.IHandlingEventService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
@RequestMapping("/event")
public class HandlingEventController {
    @Resource
    private IHandlingEventService handlingEventService;

    @RequestMapping(method = RequestMethod.POST)
    public void addHandlingEvent(@RequestBody HandlingEvent cmd) {
        handlingEventService.save(cmd);
    }
}
