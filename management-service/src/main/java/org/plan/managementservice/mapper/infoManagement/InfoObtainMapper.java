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
    List <RangeName> getRangeName(Integer brandId);

    // 获取所有的系列名称
    @Select("SELECT id, name FROM `range`;")
    List <RangeName> getAllRangeName();

    // 获取系列response信息
    @Select("SELECT `range`.*, customer.name as customerName, brand.name as brandName, clothingLevel.name as clothingLevelName FROM `range`, customer, brand, clothingLevel WHERE range.customerId = customer.id and range.brandId = brand.id and range.clothingLevelId = clothingLevel.id;")
    List <RangeResponse> getRangeResponse();

    // 根据搜索条件获取系列response信息
    @SelectProvider(type = InfoObtainProvider.class, method = "getRangeResponseByCondition")
    List <RangeResponse> getRangeResponseByCondition(@Param("rangeSearchRequest") RangeSearchRequest rangeSearchRequest);

    // 获取最后一条range
    @Select("SELECT * FROM `range` order by id desc limit 1;")
    Range getLastRange();

    // 根据rangeId获取款式组名称
    @Select("SELECT id, name FROM stylegroup WHERE rangeId=#{rangeId};")
    List <StyleGroupName> getStyleGroupNameByRangeId(int rangeId);

    // 获取所有的款式组名称
    @Select("SELECT id, name FROM stylegroup;")
    List <StyleGroupName> getAllStyleGroupName();

    // 根据搜索条件获取款式组response信息
    @SelectProvider(type = InfoObtainProvider.class, method = "getStyleGroupResponseByCondition")
    List <StyleGroupResponse> getStyleGroupResponseByCondition(@Param("styleGroupSearchRequest") StyleGroupSearchRequest styleGroupSearchRequest);

    // 根据款式组名称获取款式组
    @Select("SELECT * FROM stylegroup WHERE name=#{name};")
    List <StyleGroup> getStyleGroupByName(String name);

    // 根据id获取款式组
    @Select("SELECT * FROM stylegroup WHERE id=#{id};")
    List <StyleGroup> getStyleGroupById(int id);

    // 获取最后一条款式组
    @Select("SELECT * FROM stylegroup order by id desc limit 1;")
    StyleGroup getLastStyleGroup();

    // 根据rangeId获取款号
    @Select("SELECT id, number FROM style WHERE rangeId=#{rangeId};")
    List <StyleNumber> getStyleNumberByRangeId(int rangeId);

    // 获取所有款号
    @Select("SELECT id, number FROM style;")
    List <StyleNumber> getAllStyleNumber();

    // 根据搜索条件获取款式response信息
    @SelectProvider(type = InfoObtainProvider.class, method = "getStyleResponseByCondition")
    List <StyleResponse> getStyleResponseByCondition(@Param("styleSearchRequest") StyleSearchRequest styleSearchRequest);

    // 根据款号获取系列
    @Select("SELECT * FROM style WHERE number=#{number};")
    List <Style> getStyleByNumber(String number);

    // 根据id获取款式
    @Select("SELECT * FROM style WHERE id=#{id};")
    List <Style> getStyleById(int id);

    // 根据styleGroupId获取款式
    @Select("SELECT * FROM style WHERE styleGroupId=#{styleGroupId};")
    List <Style> getStyleByStyleGroupId(int styleGroupId);
}
