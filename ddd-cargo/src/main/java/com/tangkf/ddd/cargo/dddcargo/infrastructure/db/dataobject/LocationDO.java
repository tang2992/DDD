package com.tangkf.ddd.cargo.dddcargo.infrastructure.db.dataobject;

import com.baomidou.mybatisplus.annotation.TableId;
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
public class LocationDO {

    private static final long serialVersionUID = 1L;
    @TableId
    private String code;

    private String name;


}
