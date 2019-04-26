package org.plan.managementfacade.service.infoService;

import org.plan.managementfacade.model.infoModel.requestModel.RangeAddRequest;
import org.plan.managementfacade.model.infoModel.requestModel.RangeUpdateRequest;
import org.springframework.stereotype.Service;

@Service
public interface InfoUpdateService {
    // 更新系列信息
    int updateRange (RangeUpdateRequest rangeUpdateRequest);
}
