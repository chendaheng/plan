package org.plan.managementservice.mapper.infoManagement;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.plan.managementfacade.model.infoModel.requestModel.*;
import org.plan.managementfacade.model.infoModel.responseModel.*;
import org.plan.managementfacade.model.infoModel.sqlModel.*;
import org.springframework.web.servlet.view.script.ScriptTemplateConfig;

import java.util.List;

@Mapper
public interface InfoObtainMapper {

    // 根据系列名称获取系列
    @Select("SELECT * FROM `range` WHERE name=#{name};")
    List <Range> getRangeByName(String name);

    // 根据brandId获取系列名称
    @Select("SELECT id, name FROM `range` WHERE brandId=#{brandId};")
    List <RangeName> getRangeName(int brandId);

    // 获取系列response信息
    @Select("SELECT `range`.*, customer.name as customerName, brand.name as brandName, clothingLevel.name as clothingLevelName FROM `range`, customer, brand, clothingLevel WHERE range.customerId = customer.id and range.brandId = brand.id and range.clothingLevelId = clothingLevel.id;")
    List <RangeResponse> getRangeResponse();

    // 根据搜索条件获取系列response信息
    @SelectProvider(type = InfoObtainProvider.class, method = "getRangeResponseByCondition")
    List <RangeResponse> getRangeResponseByCondition(@Param("rangeSearchRequest") RangeSearchRequest rangeSearchRequest);

    // 根据rangeId获取款式组名称
    @Select("SELECT id, name FROM stylegroup WHERE rangeId=#{rangeId};")
    List <StyleGroupName> getStyleGroupNameByRangeId(int rangeId);

    // 根据搜索条件获取款式组response信息
    @SelectProvider(type = InfoObtainProvider.class, method = "getStyleGroupResponseByCondition")
    List <StyleGroupResponse> getStyleGroupResponseByCondition(@Param("styleGroupSearchRequest") StyleGroupSearchRequest styleGroupSearchRequest);

    // 根据款式组名称获取款式组
    @Select("SELECT * FROM stylegroup WHERE name=#{name};")
    List <StyleGroup> getStyleGroupByName(String name);

    // 根据id获取款式组
    @Select("SELECT * FROM stylegroup WHERE id=#{id};")
    List <StyleGroup> getStyleGroupById(int id);

    // 根据rangeId获取款号
    @Select("SELECT id, number FROM style WHERE rangeId=#{rangeId};")
    List <StyleNumber> getStyleNumberByRangeId(int rangeId);

    // 根据搜索条件获取款式response信息
    @SelectProvider(type = InfoObtainProvider.class, method = "getStyleResponseByCondition")
    List <StyleResponse> getStyleResponseByCondition(@Param("styleSearchRequest") StyleSearchRequest styleSearchRequest);

    // 根据款号获取系列
    @Select("SELECT * FROM style WHERE number=#{number};")
    List <Style> getStyleByNumber(String number);

    // 根据id获取款式
    @Select("SELECT * FROM style WHERE id=#{id};")
    List <Style> getStyleById(int id);
}