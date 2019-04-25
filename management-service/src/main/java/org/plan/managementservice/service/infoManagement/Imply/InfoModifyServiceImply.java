package org.plan.managementservice.service.infoManagement.Imply;

import org.plan.managementfacade.model.baseInfoModel.sqlModel.Brand;
import org.plan.managementfacade.model.infoModel.requestModel.RangeAddRequest;
import org.plan.managementfacade.model.infoModel.sqlModel.Range;
import org.plan.managementfacade.service.infoService.InfoModifyService;
import org.plan.managementservice.general.ErrorCode;
import org.plan.managementservice.mapper.baseInfoManagement.BaseInfoObtainMapper;
import org.plan.managementservice.mapper.infoManagement.InfoModifyMapper;
import org.plan.managementservice.mapper.infoManagement.InfoObtainMapper;
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
}
