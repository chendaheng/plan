package org.plan.managementfacade.service.infoService;

import org.plan.managementfacade.model.infoModel.requestModel.*;
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

    // 新增款式组
    int addStyleGroup(StyleGroupAddRequest styleGroupAddRequest);

    // 删除款式组
    int deleteStyleGroup(int id);

    // 新增款式
    int addStyle(StyleAddRequest styleAddRequest);

    // 批量新增款式
    int addStyleList(List <StyleAddRequest> styleAddRequestList);

    // 删除款式
    int deleteStyle(int id);
}
