package org.plan.managementservice.service.baseInfoManagement.Imply;

import org.plan.managementfacade.model.baseInfoModel.requestModel.BrandReq;
import org.plan.managementfacade.model.baseInfoModel.requestModel.ClothingLevelReq;
import org.plan.managementfacade.model.baseInfoModel.requestModel.CustomerReq;
import org.plan.managementfacade.model.baseInfoModel.requestModel.ProductReq;
import org.plan.managementservice.general.ErrorCode;
import org.plan.managementservice.mapper.baseInfoManagement.BaseInfoModifyMapper;
import org.plan.managementservice.mapper.baseInfoManagement.BaseInfoObtainMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BaseInfoModifyServiceImply {
    @Autowired
    private BaseInfoModifyMapper baseInfoModifyMapper;
    @Autowired
    private BaseInfoObtainMapper baseInfoObtainMapper;

    public int addProduct (ProductReq productReq) {
        int result;
        // 确保产品编码不重复,同部门下产品名称不重复(number不重复由数据库控制，通过try/catch抓取错误)
        int count = baseInfoObtainMapper.countProductByNameAndDept(productReq.getName(), productReq.getDeptName());
        if (count > 0) {
            result = ErrorCode.paramDuplication;
        } else {
            try {
                result = baseInfoModifyMapper.addProduct(productReq);
            }catch (Exception e) {
                e.printStackTrace();
                result = ErrorCode.paramDuplication;
            }
        }
        return result;
    }

    public int addCustomer (CustomerReq customerReq) {
        int result;
        // 确保客户名称不重复,由数据库控制
        try {
            result = baseInfoModifyMapper.addCustomer(customerReq);
        } catch (Exception e) {
            e.printStackTrace();
            result = ErrorCode.paramDuplication;
        }
        return result;
    }

    public int addBrand (BrandReq brandReq) {
        int result;
        // 确保同一客户之下的品牌名称不重复
        int count = baseInfoObtainMapper.countBrandByNameAndCustomer(brandReq.getName(), brandReq.getCustomerId());
        if (count > 0) {
            result = ErrorCode.paramDuplication;
        } else {
            result = baseInfoModifyMapper.addBrand(brandReq);
        }
        return result;
    }

    public int addClothingLevel (ClothingLevelReq clothingLevelReq) {
        int result;
        // 确保服装层次的名称不重复,由数据库控制
        try {
            result = baseInfoModifyMapper.addClothingLevel(clothingLevelReq);
        } catch (Exception e) {
            result = ErrorCode.paramDuplication;
        }
        return result;
    }

    public int deleteProduct (int id) {
        return baseInfoModifyMapper.deleteProduct(id);
    }

    public int deleteCustomer (int id) {
        return baseInfoModifyMapper.deleteCustomer(id);
    }

    public int deleteBrand (int id) {
        return baseInfoModifyMapper.deleteBrand(id);
    }

    public int deleteClothingLevel (int id) {
        return baseInfoModifyMapper.deleteClothingLevel(id);
    }
}
