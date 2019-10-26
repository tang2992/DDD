package com.tangkf.ddd.cargo.dddcargo.domain.repository;

import com.tangkf.ddd.cargo.dddcargo.domain.entity.Cargo;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author tangkf
 * @since 2019-10-22
 */
public interface CargoRepository {
    void save(Cargo cargo);

    List<Cargo> selectAll();

    Cargo getById(String cargoId);

    List<Cargo> selectByCustomer(String senderPhone);
}
