package org.plan.managementservice.mapper.infoManagement;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.plan.managementfacade.model.infoModel.requestModel.RangeSearchRequest;
import org.plan.managementfacade.model.infoModel.responseModel.*;
import org.plan.managementfacade.model.infoModel.sqlModel.*;

import java.util.List;

@Mapper
public interface InfoObtainMapper {

    // 根据系列名称获取系列
    @Select("SELECT * FROM `range` WHERE name=#{name};")
    List <Range> getRangeByName(String name);

    // 获取系列名称
    @Select("SELECT id, name FROM `range`;")
    List <RangeName> getRangeName();

    // 获取系列response信息
    @Select("SELECT `range`.*, customer.name as customerName, brand.name as brandName, clothingLevel.name as clothingLevelName FROM `range`, customer, brand, clothingLevel WHERE range.customerId = customer.id and range.brandId = brand.id and range.clothingLevelId = clothingLevel.id;")
    List <RangeResponse> getRangeResponse();

    // 根据搜索条件获取系列response信息
    @SelectProvider(type = InfoObtainProvider.class, method = "getRangeResponseByCondition")
    List <RangeResponse> getRangeResponseByCondition(@Param("rangeSearchRequest") RangeSearchRequest rangeSearchRequest);

    // 根据rangeId获取款式组名称
    @Select("SELECT id, name FROM stylegroup WHERE rangeId=#{rangeId};")
    List <StyleGroupName> getStyleGroupNameByRangeId(int rangeId);
}
