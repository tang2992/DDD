package com.tangkf.ddd.cargo.dddcargo.application;

import com.tangkf.ddd.cargo.dddcargo.application.dto.*;

import java.util.List;


/**
 * <p>
 *  服务类
 * </p>
 *
 * @author tangkf
 * @since 2019-10-22
 */
public interface CargoService {
    /**
     * 预定
     * @param cmd
     */
    void book(CargoBookCmd cmd);

    List<CargoVo> queryCargos();

    /**
     * @param qry
     * @return
     */
    List<CargoVo> queryCargos(CargoQueryByCustomerQry qry);

    CargoVo getCargo(String cargoId);

    DeliveryHistoryVo queryHistory(String cargoId);

    void updateCargoSender(CargoSenderUpdateCmd cmd);

    void updateCargoDelivery(CargoDeliveryUpdateCmd cmd);
}
