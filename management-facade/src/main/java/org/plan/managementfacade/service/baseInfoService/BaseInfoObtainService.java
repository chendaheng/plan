package org.plan.managementfacade.service.baseInfoService;

import org.plan.managementfacade.model.baseInfoModel.responseModel.BrandName;
import org.plan.managementfacade.model.baseInfoModel.responseModel.ClothingLevelName;
import org.plan.managementfacade.model.baseInfoModel.responseModel.CustomerName;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public interface BaseInfoObtainService {

    // 获取客户名称
    List <CustomerName> getCustomerName();

    // 获取品牌名称
    List <BrandName> getBrandName();

    // 获取服装层次名称
    List <ClothingLevelName> getClothingLevelName();
}
