package org.plan.managementservice.service.infoManagement.Imply;

import org.plan.managementfacade.model.infoModel.requestModel.*;
import org.plan.managementfacade.model.infoModel.responseModel.*;
import org.plan.managementfacade.service.infoService.*;
import org.plan.managementservice.mapper.infoManagement.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class InfoObtainServiceImply implements InfoObtainService {

    @Autowired
    private InfoObtainMapper infoObtainMapper;

    @Override
    public List <RangeName> getRangeName() {
        // 获取系列名称
        return infoObtainMapper.getRangeName();
    }

    @Override
    public List <RangeResponse> getRangeResponse(RangeSearchRequest rangeSearchRequest) {
        // 获取系列response信息
        return infoObtainMapper.getRangeResponseByCondition(rangeSearchRequest);
    }

    @Override
    public List <StyleGroupName> getStyleGroupName(int rangeId) {
        // 获取款式组名称
        return infoObtainMapper.getStyleGroupNameByRangeId(rangeId);
    }
}
