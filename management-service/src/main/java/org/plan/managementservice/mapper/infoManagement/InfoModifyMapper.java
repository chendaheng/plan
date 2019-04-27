package org.plan.managementservice.mapper.infoManagement;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.plan.managementfacade.model.infoModel.requestModel.*;

@Mapper
public interface InfoModifyMapper {

    // 新增系列
    @InsertProvider(type = InfoModifyProvider.class, method = "addRange")
    int addRange(@Param("rangeAddRequest") RangeAddRequest rangeAddRequest);

    // 删除系列
    @Delete("DELETE FROM `range` WHERE id=#{id};")
    int deleteRange(int id);

    // 新增款式组
    @InsertProvider(type = InfoModifyProvider.class, method = "addStyleGroup")
    int addStyleGroup(@Param("styleGroupAddRequest") StyleGroupAddRequest styleGroupAddRequest);

    // 删除款式组
    @Delete("DELETE FROM stylegroup WHERE id=#{id};")
    int deleteStyleGroup(int id);

    // 新增款式
    @InsertProvider(type = InfoModifyProvider.class, method = "addStyle")
    int addStyle(@Param("styleAddRequest") StyleAddRequest styleAddRequest);

    // 删除款式
    @Delete("DELETE FROM style WHERE id=#{id};")
    int deleteStyle(int id);

}
