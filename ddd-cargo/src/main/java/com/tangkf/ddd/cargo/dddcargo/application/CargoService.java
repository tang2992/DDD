package com.tangkf.ddd.cargo.dddcargo.application;

import com.tangkf.ddd.cargo.dddcargo.application.dto.CargoBookCmd;
import com.tangkf.ddd.cargo.dddcargo.application.dto.CargoDTO;
import com.tangkf.ddd.cargo.dddcargo.application.dto.CargoQueryByCustomerQry;
import com.tangkf.ddd.cargo.dddcargo.application.dto.DeliveryHistoryVo;

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

    List<CargoDTO> queryCargos();

    /**
     * @param qry
     * @return
     */
    List<CargoDTO> queryCargos(CargoQueryByCustomerQry qry);

    CargoDTO getCargo(String cargoId);

    DeliveryHistoryVo queryHistory(String cargoId);
}
