package com.tangkf.ddd.cargo.dddcargo.application.impl;

import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import com.tangkf.ddd.cargo.dddcargo.application.CargoService;
import com.tangkf.ddd.cargo.dddcargo.application.assembler.CargoDTOAssembler;
import com.tangkf.ddd.cargo.dddcargo.application.assembler.DeliveryHistoryVoAssembler;
import com.tangkf.ddd.cargo.dddcargo.application.dto.*;
import com.tangkf.ddd.cargo.dddcargo.domain.aggregate.DeliveryHistory;
import com.tangkf.ddd.cargo.dddcargo.domain.entity.Cargo;
import com.tangkf.ddd.cargo.dddcargo.domain.entity.HandlingEvent;
import com.tangkf.ddd.cargo.dddcargo.domain.repository.CargoRepository;
import com.tangkf.ddd.cargo.dddcargo.domain.repository.HandlingEventRepository;
import com.tangkf.ddd.cargo.dddcargo.domain.service.CargoDomainService;
import com.tangkf.ddd.cargo.dddcargo.domain.valueobject.DeliverySpecification;
import com.tangkf.ddd.cargo.dddcargo.infrastructure.event.DomainEventPublisher;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

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
    @Resource
    private HandlingEventRepository handlingEventRepository;

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
    public List<CargoVo> queryCargos() {
        List<Cargo> cargoList = cargoRepository.selectAll();

        return cargoList.stream().map(cargoDTOAssembler::apply).collect(Collectors.toList());
    }

    @Override
    public List<CargoVo> queryCargos(CargoQueryByCustomerQry qry) {
        List<Cargo> cargoList = cargoRepository.selectByCustomer(qry.getSenderPhone());

        return cargoList.stream().map(cargoDTOAssembler::apply).collect(Collectors.toList());
    }

    @Override
    public CargoVo getCargo(String cargoId) {
        Cargo cargo = cargoRepository.getById(cargoId);
        return cargoDTOAssembler.apply(cargo);
    }

    @Override
    public DeliveryHistoryVo queryHistory(String cargoId) {

        DeliveryHistory deliveryHistory = cargoDomainService.queryHistory(cargoId);


        return deliveryHistoryVoAssembler.apply(deliveryHistory);
    }

    @Override
    public void updateCargoSender(CargoSenderUpdateCmd cmd) {
        // find
        Cargo cargo = cargoRepository.getById(cmd.getCargoId());
        // 判断货物是否存在，不存在则拒绝修改
        if (cargo == null) {
            throw new RuntimeException("货运订单不存在");
        }

        List<HandlingEvent> events = handlingEventRepository.selectByCargo(cmd.getCargoId());

        // domain service
        cargoDomainService.updateCargoSender(cargo, cmd.getSenderPhone(), CollectionUtils.isEmpty(events) ? null : events.get(0));

    }

    @Override
    public void updateCargoDelivery(CargoDeliveryUpdateCmd cmd) {
        // find
        Cargo cargo = cargoRepository.getById(cmd.getCargoId());
        // 判断货物是否存在，不存在则拒绝修改
        if (cargo == null) {
            throw new RuntimeException("货运订单不存在");
        }

        Cargo updCargo = new Cargo();
        DeliverySpecification deliverySpecification = new DeliverySpecification();
        deliverySpecification.setDestinationLocationCode(cmd.getDestinationLocationCode());
        updCargo.setDeliverySpecification(deliverySpecification);
        cargoRepository.save(updCargo);
    }
}
