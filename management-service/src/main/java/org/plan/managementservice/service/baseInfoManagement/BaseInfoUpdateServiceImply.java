package org.plan.managementservice.service.baseInfoManagement;

import org.plan.managementfacade.model.baseInfoModel.sqlModel.*;
import org.plan.managementservice.general.ErrorCode;
import org.plan.managementservice.mapper.baseInfoManagement.BaseInfoObtainMapper;
import org.plan.managementservice.mapper.baseInfoManagement.BaseInfoUpdateMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BaseInfoUpdateServiceImply {
    @Autowired
    private BaseInfoUpdateMapper baseInfoUpdateMapper;
    @Autowired
    private BaseInfoObtainMapper baseInfoObtainMapper;

    public int updateProduct (Product product) {
        int result;
        String name = product.getName();
        String deptName = product.getDeptName();
        List<Product> productList = baseInfoObtainMapper.getProductByNameAndDept(name, deptName);
        // 确保更新后数据库中产品在同部门下name唯一
        switch (productList.size()) {
            case 0:
                try {
                    result = baseInfoUpdateMapper.updateProduct(product);
                } catch (Exception e) {
                    // 数据库中要求product的name唯一，不符合抓取异常并返回错误值
                    e.printStackTrace();
                    result = ErrorCode.paramDuplication;
                }
                break;
            case 1:
                int id = productList.get(0).getId();
                // 有一条记录重复时，若id相等则为待更新记录，正常更新，否则返回错误值
                if (product.getId() == id) {
                    try {
                        result = baseInfoUpdateMapper.updateProduct(product);
                    } catch (Exception e) {
                        e.printStackTrace();
                        result = ErrorCode.paramDuplication;
                    }
                } else {
                    result = ErrorCode.paramDuplication;
                }
                break;
            default:
                // 记录数大于1说明数据库存储数据有误，需运维人员检查
                result = ErrorCode.databaseError;
        }
        return result;
    }

    public int updateCustomer (Customer customer) {
        int result;
        // customer名称不得重复，由数据库设定，不符合则抓获异常并返回错误值
        try {
            result = baseInfoUpdateMapper.updateCustomer(customer);
        } catch (Exception e){
            e.printStackTrace();
            result = ErrorCode.paramDuplication;
        }
        return result;
    }

    public int updateBrand (Brand brand) {
        // 确保同一客户下的品牌name不重复
        int result;
        List<Brand> brandList = baseInfoObtainMapper.getBrandByNameAndCustomer(brand.getName(), brand.getCustomerId());
        switch (brandList.size()) {
            case 0:
                result = baseInfoUpdateMapper.updateBrand(brand);
                break;
            case 1:
                int id = brandList.get(0).getId();
                if (id == brand.getId()) {
                    result = baseInfoUpdateMapper.updateBrand(brand);
                } else {
                    result = ErrorCode.paramDuplication;
                }
                break;
            default:
                result = ErrorCode.databaseError;
                break;
        }
        return result;
    }

    public int updateClothingLevel (ClothingLevel clothingLevel) {
        int result = 0;
        // 服装层次的name不得重复
        try {
            result = baseInfoUpdateMapper.updateClothingLevel(clothingLevel);
        } catch (Exception e) {
            e.printStackTrace();
            result = ErrorCode.paramDuplication;
        }
        return result;
    }

    public int updateSerialNoRegular(SerialNoRegular serialNoRegular){
        // 更新单号规则 (前端做判断,没有变化则不穿)
        Integer id = serialNoRegular.getId();
        String numberPrefix = serialNoRegular.getNumberPrefix();
        Integer numberLength = serialNoRegular.getNumberLength();
        Integer lastNumberLength = serialNoRegular.getLastNumberLength();
        return baseInfoUpdateMapper.updateSerialNoRegular(id, numberPrefix, numberLength, lastNumberLength);
    }
}
