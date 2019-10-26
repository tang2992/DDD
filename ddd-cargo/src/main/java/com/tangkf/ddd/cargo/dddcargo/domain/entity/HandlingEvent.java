package com.tangkf.ddd.cargo.dddcargo.domain.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.tangkf.ddd.cargo.dddcargo.domain.enums.EventTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

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
@Builder
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class HandlingEvent {

    private static final long serialVersionUID = 1L;
    private String id;

    private String cargoId;

    @JsonProperty("eventType")
    private EventTypeEnum eventType;

    private String scheduleId;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date datetime;

    public boolean canModifyCargo() {
        return eventType == EventTypeEnum.RECIEVE;
    }
}
