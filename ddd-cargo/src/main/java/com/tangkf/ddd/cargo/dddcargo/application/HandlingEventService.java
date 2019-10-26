package com.tangkf.ddd.cargo.dddcargo.application;

import com.tangkf.ddd.cargo.dddcargo.application.dto.HandlingEventAddCmd;

public interface HandlingEventService {

    void save(HandlingEventAddCmd cmd);
}
