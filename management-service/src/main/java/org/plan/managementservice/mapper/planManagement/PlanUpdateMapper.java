package org.plan.managementservice.mapper.planManagement;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface PlanUpdateMapper {
    @Update("UPDATE plan SET state = #{state} WHERE id=#{id};")
    int updatePlanState (int id, int state);
}
