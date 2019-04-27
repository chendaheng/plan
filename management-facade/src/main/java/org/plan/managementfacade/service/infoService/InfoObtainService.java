package org.plan.managementfacade.service.infoService;

import org.plan.managementfacade.model.infoModel.requestModel.*;
import org.plan.managementfacade.model.infoModel.responseModel.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface InfoObtainService {

    // 根据brandId获取系列名称
    List <RangeName> getRangeName(int brandId);

    // 获取系列response信息
    List <RangeResponse> getRangeResponse(RangeSearchRequest rangeSearchRequest);

    // 根据rangeId获取款式组名称
    List <StyleGroupName> getStyleGroupName(int rangeId);

    // 获取款式组response信息
    List <StyleGroupResponse> getStyleGroupResponse(StyleGroupSearchRequest styleGroupSearchRequest);

    // 根据rangeId获取款号
    List <StyleNumber> getStyleNumber(int rangeId);

    // 获取款式response信息
    List <StyleResponse> getStyleResponse(StyleSearchRequest styleSearchRequest);
}
