package com.tangkf.ddd.cargo.dddcargo.domain.entity;

import lombok.Data;
import lombok.experimental.Accessors;


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
public class Location {

    private String code;

    private String name;


}
