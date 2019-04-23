package org.plan.managementservice.mapper.infoManagement;

import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.plan.managementfacade.model.infoModel.requestModel.*;

@Mapper
public interface InfoModifyMapper {

    // 新增系列
    @InsertProvider(type = InfoModifyProvider.class, method = "addRange")
    int addRange(@Param("rangeAddRequest") RangeAddRequest rangeAddRequest);

}
