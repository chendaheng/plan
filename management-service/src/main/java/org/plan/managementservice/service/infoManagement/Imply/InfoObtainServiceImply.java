package org.plan.managementservice.service.infoManagement.Imply;

import org.plan.managementfacade.model.enumModel.AddingMode;
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
    public List <RangeName> getRangeName(int brandId) {
        // 获取系列名称
        return infoObtainMapper.getRangeName(brandId);
    }

    @Override
    public List <RangeResponse> getRangeResponse(RangeSearchRequest rangeSearchRequest) {
        // 获取系列response信息
        List <RangeResponse> rangeResponseResult = infoObtainMapper.getRangeResponseByCondition(rangeSearchRequest);
        for (RangeResponse rangeResponse: rangeResponseResult){
            int addingMode = rangeResponse.getAddingMode();
            String addingModeStr = AddingMode.getType(addingMode);
            rangeResponse.setAddingModeStr(addingModeStr);
        }
        return rangeResponseResult;
    }

    @Override
    public List <StyleGroupName> getStyleGroupName(int rangeId) {
        // 获取款式组名称
        return infoObtainMapper.getStyleGroupNameByRangeId(rangeId);
    }

    @Override
    public List <StyleNumber> getStyleNumber(int rangeId) {
        // 根据rangeId获取款号
        return infoObtainMapper.getStyleNumberByRangeId(rangeId);
    }
}
