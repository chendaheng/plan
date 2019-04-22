package org.plan.managementservice.mapper.planManagement;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface PlanObtainMapper {
    @Select("SELECT state FROM Plan WHERE id=#{id};")
    int getPlanStateById (int id);
}
