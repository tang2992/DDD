package com.tangkf.ddd.cargo.dddcargo.infrastructure.db.repository;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tangkf.ddd.cargo.dddcargo.domain.entity.CarrierMovement;
import com.tangkf.ddd.cargo.dddcargo.domain.repository.CarrierMovementRepository;
import com.tangkf.ddd.cargo.dddcargo.infrastructure.db.converter.CarrierMovementConverter;
import com.tangkf.ddd.cargo.dddcargo.infrastructure.db.dataobject.CarrierMovementDO;
import com.tangkf.ddd.cargo.dddcargo.infrastructure.db.mapper.CarrierMovementMapper;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author tangkf
 * @since 2019-10-22
 */
@Service
public class CarrierMovementRepositoryImpl extends ServiceImpl<CarrierMovementMapper, CarrierMovementDO> implements CarrierMovementRepository {

    @Override
    public CarrierMovement getById(String scheduleId) {
        if (StringUtils.isEmpty(scheduleId)) {
            return null;
        }
        CarrierMovementDO carrierMovementDO = super.getById(scheduleId);
        if (carrierMovementDO == null) {
            return null;
        }
        return CarrierMovementConverter.deserialize(carrierMovementDO);

    }
}
