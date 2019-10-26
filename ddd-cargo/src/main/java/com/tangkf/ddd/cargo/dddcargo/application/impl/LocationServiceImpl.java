package com.tangkf.ddd.cargo.dddcargo.application.impl;

import com.tangkf.ddd.cargo.dddcargo.application.LocationService;
import com.tangkf.ddd.cargo.dddcargo.domain.entity.Location;
import com.tangkf.ddd.cargo.dddcargo.domain.repository.LocationRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class LocationServiceImpl implements LocationService {
    @Resource
    private LocationRepository locationRepository;

    @Override
    public List<Location> list() {
        return locationRepository.selectAll();
    }
}
