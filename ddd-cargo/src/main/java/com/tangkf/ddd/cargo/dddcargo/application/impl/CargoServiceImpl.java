package com.tangkf.ddd.cargo.dddcargo.application.impl;

import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import com.tangkf.ddd.cargo.dddcargo.application.CargoService;
import com.tangkf.ddd.cargo.dddcargo.application.assembler.CargoDTOAssembler;
import com.tangkf.ddd.cargo.dddcargo.application.assembler.DeliveryHistoryVoAssembler;
import com.tangkf.ddd.cargo.dddcargo.application.dto.CargoBookCmd;
import com.tangkf.ddd.cargo.dddcargo.application.dto.CargoDTO;
import com.tangkf.ddd.cargo.dddcargo.application.dto.CargoQueryByCustomerQry;
import com.tangkf.ddd.cargo.dddcargo.application.dto.DeliveryHistoryVo;
import com.tangkf.ddd.cargo.dddcargo.domain.aggregate.DeliveryHistory;
import com.tangkf.ddd.cargo.dddcargo.domain.entity.Cargo;
import com.tangkf.ddd.cargo.dddcargo.domain.repository.CargoRepository;
import com.tangkf.ddd.cargo.dddcargo.domain.service.CargoDomainService;
import com.tangkf.ddd.cargo.dddcargo.domain.valueobject.DeliverySpecification;
import com.tangkf.ddd.cargo.dddcargo.infrastructure.event.DomainEventPublisher;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author tangkf
 * @since 2019-10-22
 */
@Slf4j
@Service
public class CargoServiceImpl implements CargoService {
    @Resource
    private DomainEventPublisher eventPublisher;
    @Resource
    private CargoRepository cargoRepository;
    @Resource
    private CargoDomainService cargoDomainService;

    @Autowired
    private CargoDTOAssembler cargoDTOAssembler;
    @Autowired
    private DeliveryHistoryVoAssembler deliveryHistoryVoAssembler;

    @Override
    public void book(CargoBookCmd cmd) {
        // 对象转换
        Cargo cargo = new Cargo();
        cargo.setSenderPhone(cmd.getSenderPhone());
        cargo.setDescription(cmd.getDescription());
        cargo.setDeliverySpecification(DeliverySpecification.builder()
                .originLocationCode(cmd.getOriginLocationCode())
                .destinationLocationCode(cmd.getDestinationLocationCode())
                .build());
        cargo.setId(IdWorker.getIdStr());

        // TODO 配额检查

        // 发布信息
        cargoRepository.save(cargo);

        // TODO 发布货运事件
        eventPublisher.publish(cmd);
    }

    @Override
    public List<CargoDTO> queryCargos() {
        List<Cargo> cargoList = cargoRepository.selectAll();

        return cargoList.stream().map(cargoDTOAssembler::apply).collect(Collectors.toList());
    }

    @Override
    public List<CargoDTO> queryCargos(CargoQueryByCustomerQry qry) {
        List<Cargo> cargoList = cargoRepository.selectByCustomer(qry.getSenderPhone());

        return cargoList.stream().map(cargoDTOAssembler::apply).collect(Collectors.toList());
    }

    @Override
    public CargoDTO getCargo(String cargoId) {
        Cargo cargo = cargoRepository.getById(cargoId);
        return cargoDTOAssembler.apply(cargo);
    }

    @Override
    public DeliveryHistoryVo queryHistory(String cargoId) {

        DeliveryHistory deliveryHistory = cargoDomainService.queryHistory(cargoId);


        return deliveryHistoryVoAssembler.apply(deliveryHistory);
    }
}
