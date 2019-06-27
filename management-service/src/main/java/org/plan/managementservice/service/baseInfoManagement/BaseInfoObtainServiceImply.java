package org.plan.managementservice.service.baseInfoManagement;

import io.swagger.models.auth.In;
import org.plan.managementfacade.model.baseInfoModel.responseModel.*;
import org.plan.managementfacade.model.baseInfoModel.sqlModel.ClothingLevel;
import org.plan.managementfacade.model.baseInfoModel.sqlModel.Customer;
import org.plan.managementfacade.model.baseInfoModel.sqlModel.Product;
import org.plan.managementfacade.model.baseInfoModel.sqlModel.SerialNoRegular;
import org.plan.managementservice.mapper.baseInfoManagement.BaseInfoObtainMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BaseInfoObtainServiceImply {

    private final static Logger logger = LoggerFactory.getLogger("zhuriLogger");

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

    public List<BrandResp> getBrand (String name, Integer customerId) {
        return baseInfoObtainMapper.getBrandByParams(name, customerId);
    }

    public List<BrandName> getBrandName(Integer customerId, Integer userId) {
        // 获取品牌名称
        return baseInfoObtainMapper.getBrandName(customerId, userId);
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

    public List<UserName> getUserNameByBrandId (Integer brandId) {
        return baseInfoObtainMapper.getUserNameByBrandId(brandId);
    }

    public SerialNoRegular getSerialNoRegularByNumberObject(String numberObject){
        // 根据单号的对象查找单号生成规则
        List <SerialNoRegular> serialNoRegularList = baseInfoObtainMapper.getSerialNoRegularByObject(numberObject);
        if (serialNoRegularList.size() > 1){
            logger.error("同一个对象对应多个生成规则,请检查数据库");
            return null;
        }
        else if (serialNoRegularList.size() == 1){
            return serialNoRegularList.get(0);
        }
        else {
            logger.error("输入的对象为" + numberObject + "该对象不存在生成规则,请检查");
            return null;
        }
    }

    public SerialNoRegular getSerialNoRegularById(int id){
        // 根据id查找单号生成规则
        return baseInfoObtainMapper.getSerialNoRegularById(id).get(0);
    }
}
