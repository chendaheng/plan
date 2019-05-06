package org.plan.managementservice.mapper.planManagement;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.plan.managementfacade.model.enumModel.PlanState;
import org.plan.managementfacade.model.enumModel.PlanType;
import org.plan.managementfacade.model.planModel.Plan;
import org.plan.managementfacade.model.planModel.PlanExceptionResp;
import org.plan.managementfacade.model.planModel.PlanSearchResp;

import javax.validation.constraints.Size;
import java.util.List;
import java.util.Map;

@Mapper
public interface PlanObtainMapper {
    @Select("SELECT * FROM plan WHERE id=#{id};")
    Plan getPlanById(int id);

    @Select("SELECT name FROM plan WHERE id=#{id};")
    String getPlanNameById(int id);

    @Select("SELECT COUNT(*) FROM plan WHERE name=#{name} AND rangeId=#{rangeId} AND type=#{type} AND state!=#{state};")
    int countPlanByNameRangeIdType(@Param("name") String name, @Param("rangeId") int rangeId, @Param("type") PlanType type, @Param("state") PlanState state);

    @Select("SELECT id FROM plan WHERE rangeId=#{rangeId} AND type=#{type} AND isRoot=true;")
    int getRangeRootPlanId(@Param("rangeId") int rangeId, @Param("type") PlanType type);

    @Select("SELECT id FROM plan WHERE planObjectId=#{styleGroupId} AND type=#{type} AND isRoot=true;")
    int getStyleGroupRootPlanId(@Param("styleGroupId") int styleGroupId, @Param("type") PlanType type);

    @Select("SELECT startDate FROM plan WHERE id=#{id};")
    String getPlanStartDateById(int id);

    @Select("SELECT endDate FROM plan WHERE id=#{id};")
    String getPlanEndDateById(int id);

    @Select("SELECT quantity FROM plan WHERE id=#{id}")
    int getPlanQuantityById(@Param("id") int id);

    @Select("SELECT quantity FROM plan WHERE parentId=#{parentId} AND type=#{type} AND state!=#{state};")
    List<Integer> getPlanQuantityByParentIdAndType(@Param("parentId") int parentId, @Param("type") PlanType type, @Param("state") PlanState state);

    @Select("SELECT state FROM plan WHERE id=#{id};")
    PlanState getPlanStateById(int id);

    @Select("SELECT number FROM exception order by id desc limit 1;")
    String getLastExceptionNumber();

    @SelectProvider(type = PlanObtainProvider.class, method = "getPlanListInPredictByParams")
    List<PlanSearchResp> getPlanListInPredict(Map<String, Object> params);

    @SelectProvider(type = PlanObtainProvider.class, method = "getPlanListInManageByParams")
    List<PlanSearchResp> getPlanListInManage(Map<String, Object> params);

    @SelectProvider(type = PlanObtainProvider.class, method = "getPlanListInReviewByParams")
    List<PlanSearchResp> getPlanListInReview(Map<String, Object> params);

    @SelectProvider(type = PlanObtainProvider.class, method = "getPlanListInDistributeByParams")
    List<PlanSearchResp> getPlanListInDistribute(Map<String, Object> params);

    @SelectProvider(type = PlanObtainProvider.class, method = "getPlanListInDeleteByParams")
    List<PlanSearchResp> getPlanListInDelete(Map<String, Object> params);

    @SelectProvider(type = PlanObtainProvider.class, method = "getPlanExceptionListByParams")
    List<PlanExceptionResp> getPlanExceptionList(Map<String, Object> params);
}
