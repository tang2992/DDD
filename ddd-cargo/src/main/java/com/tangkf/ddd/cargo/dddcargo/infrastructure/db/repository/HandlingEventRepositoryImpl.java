package com.tangkf.ddd.cargo.dddcargo.infrastructure.db.repository;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tangkf.ddd.cargo.dddcargo.domain.entity.HandlingEvent;
import com.tangkf.ddd.cargo.dddcargo.domain.repository.HandlingEventRepository;
import com.tangkf.ddd.cargo.dddcargo.infrastructure.db.converter.HandlingEventConverter;
import com.tangkf.ddd.cargo.dddcargo.infrastructure.db.dataobject.HandlingEventDO;
import com.tangkf.ddd.cargo.dddcargo.infrastructure.db.mapper.HandlingEventMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author tangkf
 * @since 2019-10-22
 */
@Service
public class HandlingEventRepositoryImpl extends ServiceImpl<HandlingEventMapper, HandlingEventDO> implements HandlingEventRepository {

    @Override
    public void save(HandlingEvent he) {
        HandlingEventDO hed = HandlingEventConverter.serialize(he);
        super.save(hed);
    }

    @Override
    public List<HandlingEvent> selectByCargo(String cargoId) {
        QueryWrapper<HandlingEventDO> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("cargo_id", cargoId);
        List<HandlingEventDO> list = super.list(queryWrapper);

        List<HandlingEvent> handlingEvents = new ArrayList<>();
        for (HandlingEventDO hed : list) {
            handlingEvents.add(HandlingEventConverter.deserialize(hed));
        }

        return handlingEvents;
    }
}
