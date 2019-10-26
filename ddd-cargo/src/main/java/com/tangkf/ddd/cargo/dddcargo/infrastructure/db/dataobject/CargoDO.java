package com.tangkf.ddd.cargo.dddcargo.infrastructure.db.dataobject;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;


/**
 * <p>
 * 
 * </p>
 *
 * @author tangkf
 * @since 2019-10-22
 */
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Accessors(chain = true)
@TableName("ddd_cargo")
public class CargoDO implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.ID_WORKER_STR)
    private String id;

    @TableField("sender_phone")
    private String senderPhone;

    private String description;

    @TableField("originLocation_code")
    private String originLocationCode;

    @TableField("destinationLocation_code")
    private String destinationLocationCode;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;


}
