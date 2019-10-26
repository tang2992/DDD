package com.tangkf.ddd.cargo.dddcargo.domain.entity;

import com.tangkf.ddd.cargo.dddcargo.domain.valueobject.DeliverySpecification;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;


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
public class Cargo implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;

    private String senderPhone;

    private String description;

    private DeliverySpecification deliverySpecification;

}
