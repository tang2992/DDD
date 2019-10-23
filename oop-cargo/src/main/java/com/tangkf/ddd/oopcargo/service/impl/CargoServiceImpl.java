package com.tangkf.ddd.oopcargo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tangkf.ddd.oopcargo.entity.Cargo;
import com.tangkf.ddd.oopcargo.event.EventPublisher;
import com.tangkf.ddd.oopcargo.mapper.CargoMapper;
import com.tangkf.ddd.oopcargo.service.ICargoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author tangkf
 * @since 2019-10-22
 */
@Slf4j
@Service
public class CargoServiceImpl extends ServiceImpl<CargoMapper, Cargo> implements ICargoService {
    @Autowired
    private EventPublisher eventPublisher;

    @Override
    public void book(Cargo cargo) {
        // 配额检查
        // 检查客户当前的订单数量
        QueryWrapper<Cargo> tWrapper = new QueryWrapper<>();
        tWrapper.eq("sender_phone", cargo.getSenderPhone());
        Integer count = baseMapper.selectCount(tWrapper);
        log.info("count: {}", count);

        // TODO 配额检查

        // 保存货运订单
        baseMapper.insert(cargo);

        // TODO 发布货运事件
        eventPublisher.publish(cargo);
    }
}
