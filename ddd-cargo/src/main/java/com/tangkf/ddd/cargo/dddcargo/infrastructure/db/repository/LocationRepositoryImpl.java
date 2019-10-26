package com.tangkf.ddd.cargo.dddcargo.infrastructure.db.repository;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tangkf.ddd.cargo.dddcargo.domain.entity.Location;
import com.tangkf.ddd.cargo.dddcargo.domain.repository.LocationRepository;
import com.tangkf.ddd.cargo.dddcargo.infrastructure.db.converter.LocationConverter;
import com.tangkf.ddd.cargo.dddcargo.infrastructure.db.dataobject.LocationDO;
import com.tangkf.ddd.cargo.dddcargo.infrastructure.db.mapper.LocationMapper;
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
public class LocationRepositoryImpl extends ServiceImpl<LocationMapper, LocationDO> implements LocationRepository {

    @Override
    public Location getById(String code) {
        LocationDO locationDO = super.getById(code);

        return LocationConverter.deserialize(locationDO);
    }

    @Override
    public List<Location> selectAll() {
        List<LocationDO> list = super.list();

        List<Location> locationList = new ArrayList<>();
        for (LocationDO locationDO : list) {
            Location location = LocationConverter.deserialize(locationDO);
            locationList.add(location);
        }
        return locationList;
    }
}
