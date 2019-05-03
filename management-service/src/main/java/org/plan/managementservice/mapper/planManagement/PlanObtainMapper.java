package org.plan.managementservice.mapper.planManagement;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.plan.managementfacade.model.enumModel.PlanState;
import org.plan.managementfacade.model.enumModel.PlanType;
import org.plan.managementfacade.model.planModel.Plan;

import javax.validation.constraints.Size;
import java.util.List;

@Mapper
public interface PlanObtainMapper {
    @Select("SELECT * FROM plan WHERE id=#{id};")
    Plan getPlanById(int id);

    @Select("SELECT COUNT(*) FROM plan WHERE name=#{name} AND rangeId=#{rangeId} AND type=#{type};")
    int countPlanByNameRangeIdType(String name, int rangeId, PlanType type);

    @Select("SELECT id FROM plan WHERE rangeId=#{rangeId} AND type=#{type} AND isRoot=true;")
    int getRangeRootPlanId(@Param("rangeId") int rangeId, @Param("type") PlanType type);

    @Select("SELECT id FROM plan WHERE planObjectId=#{styleGroupId} AND type=#{type} AND isRoot=true;")
    int getStyleGroupRootPlanId(@Param("styleGroupId") int styleGroupId, @Param("type") PlanType type);

    @Select("SELECT startDate FROM plan WHERE id=#{id};")
    String getPlanStartDateById(int id);

    @Select("SELECT endDate FROM plan WHERE id=#{id};")
    String getPlanEndDateById(int id);

    @Select("SELECT quantity FROM plan WHERE id=#{id}")
    int getQuantityById(@Param("id") int id);

    @Select("SELECT quantity FROM plan WHERE parentId=#{parentId} AND type=#{type} AND state!=#{state};")
    List<Integer> getQuantityByParentIdAndType(@Param("parentId") int parentId, @Param("type") PlanType type, @Param("state") PlanState state);

    @Select("SELECT state FROM plan WHERE id=#{id};")
    PlanState getPlanStateById(int id);
}
