package org.plan.managementfacade.service.infoService;

import org.plan.managementfacade.model.infoModel.requestModel.RangeAddRequest;
import org.springframework.stereotype.Service;

@Service
public interface InfoModifyService {
    // 新增系列
    int addRange(RangeAddRequest rangeAddRequest);
}
