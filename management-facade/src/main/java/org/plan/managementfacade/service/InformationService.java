package org.plan.managementfacade.service;

import org.plan.managementfacade.model.infoModel.Range;
import org.plan.managementfacade.model.baseInfoModel.Brand;
import org.plan.managementfacade.model.baseInfoModel.ClothingLevel;
import org.springframework.stereotype.Service;
import org.plan.managementfacade.model.responseModel.*;
import java.util.List;

@Service
public interface InformationService {

    // 获取客户名称
    List <CustomerName> getCustomerName();

    // 获取品牌
    List <Brand> getBrandName();

    //  获取系列名称
    List <Range> getRangeName();

    // 获取服装层次
    List <ClothingLevel> getClothingLevelName();
}
