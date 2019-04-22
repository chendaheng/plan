package org.plan.managementservice.mapper;

import org.apache.ibatis.annotations.*;
import org.plan.managementfacade.model.infoModel.Range;
import org.plan.managementfacade.model.baseInfoModel.*;

import java.util.List;

@Mapper
public interface InformationMapper {

    // 获取所有的客户信息
    @Select("SELECT * FROM customer")
    List <Customer> getAllCustomer();

    // 获取所有的品牌信息
    @Select("SELECT * FROM brand")
    List <Brand> getAllBrand();

    // 获取所有的系列信息
    @Select("SELECT * FROM `range`")
    List <Range> getAllRange();

    // 获取所有的服装层次
    @Select("SELECT * FROM clothingLevel")
    List <ClothingLevel> getAllClothingLevel();
}