package org.plan.managementservice.mapper.planManagement;

import org.apache.ibatis.annotations.*;
import org.plan.managementfacade.model.enumModel.PlanState;
import org.plan.managementfacade.model.planModel.requestModel.PlanUpdateReq;

@Mapper
public interface PlanUpdateMapper {
//    @Update("UPDATE plan SET name=#{name}, projectType=#{projectType}, quantity=#{quantity}, productId=#{productId}, " +
//            "productDate=#{productDate}, productDateType=#{productDateType}, startDate=#{startDate}, endDate=#{endDate}, " +
//            "proposal=#{proposal}, description=#{description}, note=#{note} WHERE id=#{id};")
    @UpdateProvider(type = PlanUpdateProvider.class, method = "updatePlan")
    int updatePlan(PlanUpdateReq planUpdateReq);

    @Update("UPDATE plan SET state=#{state} WHERE id=#{id};")
    int updatePlanStateById(@Param("id") int id, @Param("state") PlanState state);

    @Update("UPDATE plan SET rejectReason=#{reason}, state=#{state} WHERE id=#{id};")
    int failPlanById(@Param("id") int id, @Param("reason") String reason, @Param("state") PlanState state);

    @Update("UPDATE plan SET state=#{state}, deleteTime=CURRENT_TIMESTAMP WHERE id=#{id};")
    int deletePlanById(@Param("id") int id, @Param("state") PlanState state);

    @Update("UPDATE plan SET order=#{order} WHERE id=#{id};")
    int updatePlanOrderById(int id, int order);
}
