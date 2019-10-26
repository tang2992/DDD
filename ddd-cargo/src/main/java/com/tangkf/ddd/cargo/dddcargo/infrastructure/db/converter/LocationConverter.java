package com.tangkf.ddd.cargo.dddcargo.infrastructure.db.converter;

import com.tangkf.ddd.cargo.dddcargo.domain.entity.Location;
import com.tangkf.ddd.cargo.dddcargo.infrastructure.db.dataobject.LocationDO;
import org.springframework.beans.BeanUtils;

public class LocationConverter {

    public static LocationDO serialize(Location location) {
        LocationDO target = new LocationDO();
        BeanUtils.copyProperties(location, target);
        return target;
    }

    public static Location deserialize(LocationDO locationDO) {
        Location target = new Location();
        BeanUtils.copyProperties(locationDO, target);
        return target;
    }

}
