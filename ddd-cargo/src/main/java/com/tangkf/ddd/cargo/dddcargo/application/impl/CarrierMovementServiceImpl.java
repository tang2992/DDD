package com.tangkf.ddd.cargo.dddcargo.application.impl;

import com.tangkf.ddd.cargo.dddcargo.application.CarrierMovementService;
import com.tangkf.ddd.cargo.dddcargo.application.assembler.CarrierMovementVoAssembler;
import com.tangkf.ddd.cargo.dddcargo.application.dto.CarrierMovementVo;
import com.tangkf.ddd.cargo.dddcargo.domain.entity.CarrierMovement;
import com.tangkf.ddd.cargo.dddcargo.domain.repository.CarrierMovementRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class CarrierMovementServiceImpl implements CarrierMovementService {
    @Resource
    private CarrierMovementRepository carrierMovementRepository;

    @Resource
    private CarrierMovementVoAssembler assembler;

    @Override
    public List<CarrierMovementVo> selectAll() {
        List<CarrierMovement> carrierMovementList = carrierMovementRepository.selectAll();

        List<CarrierMovementVo> carrierMovementVoList = new ArrayList<>();
        for (CarrierMovement cm : carrierMovementList) {
            carrierMovementVoList.add(assembler.apply(cm));
        }
        return carrierMovementVoList;
    }
}
