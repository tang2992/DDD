package com.tangkf.ddd.oopcargo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.Date;

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
@TableName("ddd_handling_event")
public class HandlingEvent {

    private static final long serialVersionUID = 1L;
    @TableId(type = IdType.ID_WORKER_STR)
    private String id;

    private String cargoId;

    @JsonProperty("eventType")
    private Integer eventtype;

    private String scheduleId;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date datetime;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;


}
