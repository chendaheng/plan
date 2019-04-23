package org.plan.managementfacade.service.InfoService;

import org.plan.managementfacade.model.infoModel.responseModel.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface InfoObtainService {

    // 获取系列名称
    List <RangeName> getRangeName();

    // 获取系列response信息
    List <RangeResponse> getRangeResponse();
}
