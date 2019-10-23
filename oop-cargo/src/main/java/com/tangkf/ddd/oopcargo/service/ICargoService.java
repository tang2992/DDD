package com.tangkf.ddd.oopcargo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tangkf.ddd.oopcargo.entity.Cargo;


/**
 * <p>
 *  服务类
 * </p>
 *
 * @author tangkf
 * @since 2019-10-22
 */
public interface ICargoService extends IService<Cargo> {
    /**
     * 预定
     * @param cargo
     */
    void book(Cargo cargo);
}
