package com.tangkf.ddd.cargo.dddcargo.domain.valueobject;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DeliverySpecification {
    private String originLocationCode;

    private String destinationLocationCode;
}
