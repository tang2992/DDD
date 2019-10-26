package com.tangkf.ddd.cargo.dddcargo.domain.repository;

import com.tangkf.ddd.cargo.dddcargo.domain.entity.Location;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author tangkf
 * @since 2019-10-22
 */
public interface LocationRepository {
    Location getById(String code);

    List<Location> selectAll();
}
