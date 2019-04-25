package org.plan.managementservice.service.infoManagement.Imply;

import org.plan.managementfacade.model.baseInfoModel.sqlModel.*;
import org.plan.managementfacade.model.infoModel.requestModel.*;
import org.plan.managementfacade.model.infoModel.sqlModel.*;
import org.plan.managementfacade.service.infoService.*;
import org.plan.managementservice.general.ErrorCode;
import org.plan.managementservice.mapper.baseInfoManagement.*;
import org.plan.managementservice.mapper.infoManagement.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class InfoModifyServiceImply implements InfoModifyService {

    private final static Logger logger = LoggerFactory.getLogger("zhuriLogger");

    @Autowired
    private InfoModifyMapper infoModifyMapper;

    @Autowired
    private InfoObtainMapper infoObtainMapper;

    @Autowired
    private BaseInfoObtainMapper baseInfoObtainMapper;

    @Override
    public int addRange(RangeAddRequest rangeAddRequest) {
        // 新增系列
        String name = rangeAddRequest.getName();
        List <Range> rangeResult = infoObtainMapper.getRangeByName(name);
        if (rangeResult.size() > 0){
            logger.error("数据库中已存在该系列的名称");
            return ErrorCode.dataExist;
        }else {
            rangeAddRequest.setNumber("XL_new");
            rangeAddRequest.setAddingMode(1);
            rangeAddRequest.setCreaterId(3);
            rangeAddRequest.setCreaterName("张三");
            return infoModifyMapper.addRange(rangeAddRequest);
        }
    }

    @Override
    public int addRangeList(List <RangeAddRequest> rangeAddRequestList) {
        // 批量新增系列
        int addRangeCount = 0;
        for (RangeAddRequest rangeAddRequest : rangeAddRequestList){
            String name = rangeAddRequest.getName();
            List <Range> rangeResult = infoObtainMapper.getRangeByName(name);
            if (rangeResult.size() > 0) {
                logger.info("数据库中已存在该系列的名称,当前系列的名称为:" + rangeAddRequest.getName());
            }
            else {
                rangeAddRequest.setNumber("XL_new");
                rangeAddRequest.setAddingMode(2);
                rangeAddRequest.setCreaterId(3);
                rangeAddRequest.setCreaterName("张三");
                int addResult = infoModifyMapper.addRange(rangeAddRequest);
                if (addResult == 1){
                    addRangeCount += addResult;
                }
                else {
                    logger.info("新增信息出错,当前系列的名称为:" + rangeAddRequest.getName());
                }
            }
        }
        return addRangeCount;
    }

    @Override
    public int deleteRange(int id) {
        // 删除系列
        return infoModifyMapper.deleteRange(id);
    }
}
