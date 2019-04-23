package org.plan.managementservice.mapper.InfoManagement;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.plan.managementfacade.model.infoModel.responseModel.*;

import java.util.List;

@Mapper
public interface InfoObtainMapper {

    // 获取系列名称
    @Select("SELECT id, name FROM `range`;")
    List <RangeName> getRangeName();

    // 获取系列response信息
    @Select("SELECT `range`.*, customer.name as customerName, brand.name as brandName, clothingLevel.name as clothingLevelName FROM `range`, customer, brand, clothingLevel WHERE range.customerId = customer.id and range.brandId = brand.id and range.clothingLevelId = clothingLevel.id;")
    List <RangeResponse> getRangeResponse();

    //
}
