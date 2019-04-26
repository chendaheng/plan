package org.plan.managementservice.service.infoManagement.Imply;

import org.plan.managementfacade.model.infoModel.requestModel.*;
import org.plan.managementfacade.service.infoService.InfoUpdateService;
import org.plan.managementservice.mapper.infoManagement.InfoUpdateMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InfoUpdateServiceImply implements InfoUpdateService {

    private final static Logger logger = LoggerFactory.getLogger("zhuriLogger");

    @Autowired
    private InfoUpdateMapper infoUpdateMapper;

    @Override
    public int updateRange(RangeUpdateRequest rangeUpdateRequest) {
        // 更新系列信息
        return infoUpdateMapper.updateRange(rangeUpdateRequest);
    }
}
