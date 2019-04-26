package org.plan.managementservice.service.baseInfoManagement.Imply;

import org.plan.managementfacade.model.baseInfoModel.responseModel.BrandName;
import org.plan.managementfacade.model.baseInfoModel.responseModel.ClothingLevelName;
import org.plan.managementfacade.model.baseInfoModel.responseModel.CustomerName;
import org.plan.managementfacade.service.baseInfoService.*;
import org.plan.managementservice.mapper.baseInfoManagement.BaseInfoObtainMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BaseInfoObtainServiceImply implements BaseInfoObtainService {

    @Autowired
    private BaseInfoObtainMapper baseInfoObtainMapper;

    @Override
    public List <CustomerName> getCustomerName() {
        // 获取客户名称
        return baseInfoObtainMapper.getCustomerName();
    }

    @Override
    public List <BrandName> getBrandName(int customerId) {
        // 获取品牌名称
        return baseInfoObtainMapper.getBrandName(customerId);
    }

    @Override
    public List <ClothingLevelName> getClothingLevelName() {
        // 获取服装层次名称
        return baseInfoObtainMapper.getClothingLevelName();
    }
}
