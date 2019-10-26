package com.tangkf.ddd.cargo.dddcargo.domain.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

/**
 * <p>
 * 
 * </p>
 *
 * @author tangkf
 * @since 2019-10-22
 */
@Data
@Accessors(chain = true)
public class CarrierMovement {

    private static final long serialVersionUID = 1L;

    private String scheduleId;

    private String fromLocationCode;

    private String toLocationCode;

    private LocalDateTime startTime;

    private LocalDateTime arriveTime;
}
