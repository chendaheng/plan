package org.plan.managementservice.service.baseInfoManagement.Imply;

import org.plan.managementfacade.model.baseInfoModel.responseModel.BrandName;
import org.plan.managementfacade.model.baseInfoModel.responseModel.BrandResp;
import org.plan.managementfacade.model.baseInfoModel.responseModel.ClothingLevelName;
import org.plan.managementfacade.model.baseInfoModel.responseModel.CustomerName;
import org.plan.managementfacade.model.baseInfoModel.sqlModel.ClothingLevel;
import org.plan.managementfacade.model.baseInfoModel.sqlModel.Customer;
import org.plan.managementfacade.model.baseInfoModel.sqlModel.Product;
import org.plan.managementservice.mapper.baseInfoManagement.BaseInfoObtainMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BaseInfoObtainServiceImply {

    @Autowired
    private BaseInfoObtainMapper baseInfoObtainMapper;

    public List <Product> getProduct (String name) {
        if (name == null) {
            return baseInfoObtainMapper.getAllProduct();
        } else {
            return baseInfoObtainMapper.getProductByName(name);
        }
    }

    public List<Customer> getCustomer (String name) {
        if (name == null) {
            return baseInfoObtainMapper.getAllCustomer();
        } else {
            return baseInfoObtainMapper.getCustomerByName(name);
        }
    }

    public List<CustomerName> getCustomerName(int userId) {
        // 获取客户名称
        return baseInfoObtainMapper.getCustomerName(userId);
    }

    public List<BrandResp> getBrand (String name) {
        if (name == null) {
            return baseInfoObtainMapper.getAllBrand();
        } else {
            return baseInfoObtainMapper.getBrandByName(name);
        }
    }

    public List<BrandName> getBrandName(Integer customerId, Integer userId) {
        // 获取品牌名称
        return baseInfoObtainMapper.getBrandName(customerId, userId);
//        if (customerId != null){
//            return baseInfoObtainMapper.getBrandName(customerId);
//        }
//        else {
//            return baseInfoObtainMapper.getAllBrandName();
//        }
    }

    public List<ClothingLevel> getClothingLevel (String name) {
        if (name == null) {
            return baseInfoObtainMapper.getAllClothingLevel();
        } else {
            return baseInfoObtainMapper.getClothingLevelByName(name);
        }
    }

    public List<ClothingLevelName> getClothingLevelName() {
        // 获取服装层次名称
        return baseInfoObtainMapper.getClothingLevelName();
    }
}
