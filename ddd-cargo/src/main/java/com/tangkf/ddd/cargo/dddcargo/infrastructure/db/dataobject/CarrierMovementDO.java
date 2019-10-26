package com.tangkf.ddd.cargo.dddcargo.infrastructure.db.dataobject;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
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
@TableName("ddd_carrier_movement")
public class CarrierMovementDO {

    private static final long serialVersionUID = 1L;

    @TableId
    private String scheduleId;

    @TableField("fromLocation_code")
    private String fromLocationCode;

    @TableField("toLocation_code")
    private String toLocationCode;
    @TableField("starttime")
    private LocalDateTime startTime;

    @TableField("arrivetime")
    private LocalDateTime arriveTime;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;


}
