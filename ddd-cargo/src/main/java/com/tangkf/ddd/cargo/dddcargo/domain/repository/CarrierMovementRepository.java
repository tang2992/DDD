package com.tangkf.ddd.cargo.dddcargo.domain.repository;

import com.tangkf.ddd.cargo.dddcargo.domain.entity.CarrierMovement;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author tangkf
 * @since 2019-10-22
 */
public interface CarrierMovementRepository {

    CarrierMovement getById(String scheduleId);

    List<CarrierMovement> selectAll();
}
