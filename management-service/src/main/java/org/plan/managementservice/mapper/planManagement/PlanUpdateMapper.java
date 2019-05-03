package org.plan.managementservice.mapper.planManagement;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.plan.managementfacade.model.enumModel.PlanState;
import org.plan.managementfacade.model.planModel.PlanUpdateReq;

@Mapper
public interface PlanUpdateMapper {
    @Update("UPDATE plan SET name=#{name}, projectType=#{projectType}, quantity=#{quantity}, productId=#{productId}, " +
            "productDate=#{productDate}, productDateType=#{productDateType}, startDate=#{startDate}, endDate=#{endDate}, " +
            "proposal=#{proposal}, description=#{description}, note={note} WHERE id=#{id};")
    int updatePlan(PlanUpdateReq planUpdateReq);

    @Update("UPDATE plan SET state = #{state} WHERE id=#{id};")
    int updatePlanStateById(@Param("id") int id, @Param("state") PlanState state);

    @Update("UPDATE plan SET state=#{state}, deleteTime=CURRENT_TIMESTAMP WHERE id=#{id};")
    int updatePlanStateAndDeleteTimeById(@Param("id") int id, @Param("state") PlanState state);
}
