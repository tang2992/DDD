package com.tangkf.ddd.oopcargo.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tangkf.ddd.oopcargo.entity.CarrierMovement;
import com.tangkf.ddd.oopcargo.mapper.CarrierMovementMapper;
import com.tangkf.ddd.oopcargo.service.ICarrierMovementService;
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
public class CarrierMovementServiceImpl extends ServiceImpl<CarrierMovementMapper, CarrierMovement> implements ICarrierMovementService {

}
