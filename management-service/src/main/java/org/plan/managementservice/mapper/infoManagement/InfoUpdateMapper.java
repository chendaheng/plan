package org.plan.managementservice.mapper.infoManagement;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.UpdateProvider;
import org.plan.managementfacade.model.infoModel.requestModel.RangeUpdateRequest;

@Mapper
public interface InfoUpdateMapper {

    // 更新系列信息
    @UpdateProvider(type = InfoUpdateProvider.class, method = "updateRange")
    int updateRange (@Param("rangeUpdateRequest") RangeUpdateRequest rangeUpdateRequest);
}
