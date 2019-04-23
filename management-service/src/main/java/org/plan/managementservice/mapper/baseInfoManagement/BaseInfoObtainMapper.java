package org.plan.managementservice.mapper.baseInfoManagement;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.plan.managementfacade.model.baseInfoModel.responseModel.*;
import org.plan.managementfacade.model.baseInfoModel.sqlModel.*;

import java.util.List;

@Mapper
public interface BaseInfoObtainMapper {

    // 获取客户名称
    @Select("SELECT id, name FROM customer;")
    List <CustomerName> getCustomerName();

    // 根据brandId获取品牌
    @Select("SELECT * FROM brand WHERE id=#{id};")
    List <Brand> getBrandByBrandId(int id);

    // 获取品牌名称
    @Select("SELECT id, name FROM brand WHERE customerId=#{customerId};")
    List <BrandName> getBrandName(int customerId);

    // 获取服装层次名称
    @Select("SELECT * FROM clothingLevel;")
    List <ClothingLevelName> getClothingLevelName();
}
