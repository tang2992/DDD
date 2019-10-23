package com.tangkf.ddd.oopcargo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tangkf.ddd.oopcargo.entity.Location;
import com.tangkf.ddd.oopcargo.mapper.LocationMapper;
import com.tangkf.ddd.oopcargo.service.ILocationService;
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
public class LocationServiceImpl extends ServiceImpl<LocationMapper, Location> implements ILocationService {

}
