package com.tangkf.ddd.cargo.dddcargo.domain.repository;

import com.tangkf.ddd.cargo.dddcargo.domain.entity.HandlingEvent;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author tangkf
 * @since 2019-10-22
 */
public interface HandlingEventRepository {

    void save(HandlingEvent he);

    List<HandlingEvent> selectByCargo(String cargoId);
}
