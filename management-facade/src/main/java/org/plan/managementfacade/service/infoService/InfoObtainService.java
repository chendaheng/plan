package org.plan.managementfacade.service.infoService;

import org.plan.managementfacade.model.infoModel.requestModel.*;
import org.plan.managementfacade.model.infoModel.responseModel.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface InfoObtainService {

    // 获取系列名称
    List <RangeName> getRangeName();

    // 获取系列response信息
    List <RangeResponse> getRangeResponse(RangeSearchRequest rangeSearchRequest);

    // 根据rangeId获取款式组名称
    List <StyleGroupName> getStyleGroupName(int rangeId);

    // 根据rangeId获取款号
    List <StyleNumber> getStyleNumber(int rangeId);
}
