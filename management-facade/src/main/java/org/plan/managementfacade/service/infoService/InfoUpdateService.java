package org.plan.managementfacade.service.infoService;

import org.plan.managementfacade.model.infoModel.requestModel.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface InfoUpdateService {
    // 更新系列信息
    int updateRange (RangeUpdateRequest rangeUpdateRequest);

    // 更新款式组信息
    int updateStyleGroup (StyleGroupUpdateRequest styleGroupUpdateRequest);

    // 解绑款式组
    int unbindStyleGroup (int id);

    // 更新款式信息
    int updateStyle (StyleUpdateRequest styleUpdateRequest);

    // 绑定款式组
    int bindStyleGroup (List <BindStyleGroupRequest> bindStyleGroupRequestList);
}
