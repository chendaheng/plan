package org.plan.managementfacade.service;

import org.plan.managementfacade.model.infoModel.responseModel.RangeName;
import org.springframework.stereotype.Service;
import org.plan.managementfacade.model.baseInfoModel.responseModel.*;
import java.util.List;

@Service
public interface InformationService {

    // 获取客户名称
    List <CustomerName> getCustomerName(int userId);

    // 获取品牌名称
    List <BrandName> getBrandName();

    //  获取系列名称
    List <RangeName> getRangeName();

    // 获取服装层次
    List <ClothingLevelName> getClothingLevelName();
}
