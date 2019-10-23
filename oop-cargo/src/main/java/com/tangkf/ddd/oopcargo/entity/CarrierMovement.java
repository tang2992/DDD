package com.tangkf.ddd.oopcargo.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
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
public class CarrierMovement {

    private static final long serialVersionUID = 1L;

    private String scheduleId;

    @TableField("fromLocation_code")
    private String fromlocationCode;

    @TableField("toLocation_code")
    private String tolocationCode;

    private LocalDateTime starttime;

    private LocalDateTime arrivetime;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;


}
