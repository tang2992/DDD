package com.tangkf.ddd.oopcargo.entity;

import com.baomidou.mybatisplus.annotation.TableName;
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
@TableName("ddd_location")
public class Location {

    private static final long serialVersionUID = 1L;

    private String code;

    private String name;


}
