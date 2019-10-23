package com.tangkf.ddd.oopcargo.vo;

import com.tangkf.ddd.oopcargo.entity.Cargo;
import lombok.Data;
import lombok.ToString;

/**
 * @author t00458
 */
@Data
@ToString(callSuper = true)
public class CargoVo extends Cargo {
    private String originLocationName;
    private String destinationLocationName;
}
