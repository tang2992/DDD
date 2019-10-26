package com.tangkf.ddd.cargo.dddcargo.infrastructure.db.repository;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tangkf.ddd.cargo.dddcargo.domain.entity.Cargo;
import com.tangkf.ddd.cargo.dddcargo.domain.repository.CargoRepository;
import com.tangkf.ddd.cargo.dddcargo.infrastructure.db.converter.CargoConverter;
import com.tangkf.ddd.cargo.dddcargo.infrastructure.db.dataobject.CargoDO;
import com.tangkf.ddd.cargo.dddcargo.infrastructure.db.mapper.CargoMapper;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
@Service
public class CargoRepositoryImpl extends ServiceImpl<CargoMapper, CargoDO> implements CargoRepository {

    @Override
    public void save(Cargo cargo) {
        // 保存货运订单
        CargoDO cargoDo = CargoConverter.serialize(cargo);
        saveOrUpdate(cargoDo);
    }

    @Override
    public List<Cargo> selectAll() {
        List<CargoDO> list = super.list();

        List<Cargo> cargoList = new ArrayList<>();
        for (CargoDO cargoDO : list) {
            Cargo cargo = CargoConverter.deserialize(cargoDO);
            cargoList.add(cargo);
        }
        return cargoList;
    }

    @Override
    public Cargo getById(String cargoId) {
        CargoDO cargoDO = super.getById(cargoId);
        return CargoConverter.deserialize(cargoDO);
    }

    @Override
    public List<Cargo> selectByCustomer(String senderPhone) {
        QueryWrapper<CargoDO> tWrapper = new QueryWrapper<>();
        tWrapper.eq("sender_phone", senderPhone);
        List<CargoDO> cargoDOList = baseMapper.selectList(tWrapper);

        List<Cargo> cargoList = new ArrayList<>();
        for (CargoDO cargoDO : cargoDOList) {
            Cargo cargo = CargoConverter.deserialize(cargoDO);
            cargoList.add(cargo);
        }
        return cargoList;
    }
}
