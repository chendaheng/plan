package org.plan.managementfacade.service.infoService;

import org.plan.managementfacade.model.infoModel.requestModel.RangeAddRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface InfoModifyService {
    // 新增系列
    int addRange(RangeAddRequest rangeAddRequest);

    // 批量新增系列
    int addRangeList(List <RangeAddRequest> rangeAddRequestList);

    // 删除系列
    int deleteRange(int id);
}
