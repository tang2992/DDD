package com.tangkf.ddd.oopcargo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tangkf.ddd.oopcargo.entity.HandlingEvent;
import com.tangkf.ddd.oopcargo.mapper.HandlingEventMapper;
import com.tangkf.ddd.oopcargo.service.IHandlingEventService;
import org.springframework.stereotype.Service;


/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author tangkf
 * @since 2019-10-22
 */
@Service
public class HandlingEventServiceImpl extends ServiceImpl<HandlingEventMapper, HandlingEvent> implements IHandlingEventService {

}
