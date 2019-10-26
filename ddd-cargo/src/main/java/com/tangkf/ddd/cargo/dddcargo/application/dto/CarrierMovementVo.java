package com.tangkf.ddd.cargo.dddcargo.application.dto;

import com.tangkf.ddd.cargo.dddcargo.domain.entity.CarrierMovement;
import lombok.Data;

/**
 * <p>
 * 
 * </p>
 *
 * @author tangkf
 * @since 2019-10-22
 */
@Data
public class CarrierMovementVo extends CarrierMovement {

    private static final long serialVersionUID = 1L;


    private String fromLocationName;

    private String toLocationName;
}
