package org.plan.managementservice.service.infoManagement.Imply;

import org.plan.managementfacade.model.infoModel.requestModel.*;
import org.plan.managementfacade.model.infoModel.sqlModel.*;
import org.plan.managementfacade.service.infoService.InfoUpdateService;
import org.plan.managementservice.general.ErrorCode;
import org.plan.managementservice.mapper.infoManagement.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class InfoUpdateServiceImply implements InfoUpdateService {

    private final static Logger logger = LoggerFactory.getLogger("zhuriLogger");

    @Autowired
    private InfoUpdateMapper infoUpdateMapper;

    @Autowired
    private InfoObtainMapper infoObtainMapper;

    @Override
    public int updateRange(RangeUpdateRequest rangeUpdateRequest) {
        // 更新系列信息
        return infoUpdateMapper.updateRange(rangeUpdateRequest);
    }

    @Override
    public int updateStyleGroup(StyleGroupUpdateRequest styleGroupUpdateRequest) {
        // 更新款式组信息
        String name = styleGroupUpdateRequest.getName();
        List <StyleGroup> styleGroupResult = infoObtainMapper.getStyleGroupByName(name);
        if (styleGroupResult.size() > 0){
            logger.error("数据库中已存在该款式组的名称");
            return ErrorCode.dataExist;
        }
        else {
            logger.info("此操作更新款式组基本信息");
            return infoUpdateMapper.updateStyleGroup(styleGroupUpdateRequest);
        }
    }

    @Override
    public int unbindStyleGroup(StyleGroupUpdateRequest styleGroupUpdateRequest) {
        // 解绑款式组
        styleGroupUpdateRequest.setState(1);
        return infoUpdateMapper.updateStyleGroup(styleGroupUpdateRequest);
    }
}
