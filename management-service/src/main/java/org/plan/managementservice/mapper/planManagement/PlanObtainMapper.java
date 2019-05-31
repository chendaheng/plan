package org.plan.managementservice.mapper.planManagement;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.plan.managementfacade.model.enumModel.PlanState;
import org.plan.managementfacade.model.enumModel.PlanType;
import org.plan.managementfacade.model.planModel.responseModel.ChildrenPlanResp;
import org.plan.managementfacade.model.planModel.responseModel.PlanForGantt;
import org.plan.managementfacade.model.planModel.sqlModel.Plan;
import org.plan.managementfacade.model.planModel.responseModel.PlanExceptionResp;
import org.plan.managementfacade.model.planModel.responseModel.PlanSearchResp;

import java.util.List;
import java.util.Map;

@Mapper
public interface PlanObtainMapper {
    @Select("SELECT * FROM plan WHERE id=#{id};")
    Plan getPlanById(int id);

    @Select("SELECT * FROM plan WHERE planObjectId=#{planObjectId} AND type=#{type} AND isRoot=true AND state!=#{state};")
    List<Plan> getRootPlanByPlanObjectIdAndType(@Param("planObjectId") int planObjectId, @Param("type") PlanType type, @Param("state") PlanState state);

    @Select("SELECT * FROM plan WHERE rangeId=#{rangeId} AND type=#{type} AND isRoot=true AND state!=#{state};")
    List<Plan> getRangeRootPlanByRangeIdAndType(@Param("rangeId") int rangeId, @Param("type") PlanType type, @Param("state") PlanState state);

    @Select("SELECT name FROM plan WHERE id=#{id};")
    String getPlanNameById(int id);

    @Select("SELECT number FROM plan order by id desc limit 1;")
    String getLastPlanNumber();

    @Select("SELECT COUNT(*) FROM plan WHERE name=#{name} AND rangeId=#{rangeId} AND type=#{type} AND state!=#{state};")
    int countPlanByNameRangeIdType(@Param("name") String name, @Param("rangeId") int rangeId, @Param("type") PlanType type, @Param("state") PlanState state);

    @Select("SELECT COUNT(*) FROM plan WHERE type=#{type} AND planObjectId=#{planObjectId} AND isRoot=#{getIsRoot} AND state!=#{state};")
    int countRootPlanByTypeAndPlanObject(@Param("type") PlanType type, @Param("planObjectId") int planObjectId, @Param("getIsRoot") boolean isRoot, @Param("state") PlanState state);

    @Select("SELECT id FROM plan WHERE rangeId=#{rangeId} AND type=#{type} AND isRoot=true AND state!=#{state};")
    Integer getRangeRootPlanId(@Param("rangeId") int rangeId, @Param("type") PlanType type, @Param("state") PlanState state);

    @Select("SELECT id FROM plan WHERE planObjectId=#{styleGroupId} AND type=#{type} AND isRoot=true AND state!=#{state};")
    Integer getStyleGroupRootPlanId(@Param("styleGroupId") Integer styleGroupId, @Param("type") PlanType type, @Param("state") PlanState state);

    @Select("SELECT startDate FROM plan WHERE id=#{id};")
    String getPlanStartDateById(int id);

    @Select("SELECT endDate FROM plan WHERE id=#{id};")
    String getPlanEndDateById(int id);

    @Select("SELECT quantity FROM plan WHERE id=#{id}")
    int getPlanQuantityById(int id);

    @Select("SELECT quantity FROM plan WHERE parentId=#{parentId} AND type=#{type} AND state!=#{state};")
    List<Integer> getPlanQuantityByParentIdAndType(@Param("parentId") int parentId, @Param("type") PlanType type, @Param("state") PlanState state);

    @Select("SELECT state FROM plan WHERE id=#{id};")
    PlanState getPlanStateById(int id);

    @Select("SELECT type FROM plan WHERE id=#{id};")
    PlanType getPlanTypeById(int id);

    @Select("SELECT * FROM plan WHERE planObjectId=#{planObjectId} AND type!=#{type} AND state!=#{state};")
    List<Plan> getPlanByPlanObjectId(@Param("planObjectId") int planObjectId, @Param("type") PlanType type, @Param("state") PlanState state);

    @Select("SELECT id,number,name,`order`,startDate,endDate,createrName,deptName,createTime FROM plan WHERE parentId=#{parentId} AND type=#{type} AND state!=#{state};")
    List<ChildrenPlanResp> getPlanByParentIdAndType(@Param("parentId") int parentId, @Param("type") PlanType type, @Param("state") PlanState state);

    // 为方便前端展示，将搜索得到的plan按parentId和order排序，使同一级计划order小的排在前面
    @Select("SELECT id, name, parentId, projectType, `order`, quantity, startDate, endDate, createrName, isRoot, haveException " +
            "FROM plan WHERE planObjectId=#{planObjectId} AND type!=#{type} AND state!=#{state} " +
            "ORDER BY parentId ASC, `order` ASC;")
    List<PlanForGantt> getPlanForGanttByPlanObjectId(@Param("planObjectId") int planObjectId, @Param("type") PlanType type, @Param("state") PlanState state);

    @Select("SELECT number FROM planexception order by id desc limit 1;")
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

    @SelectProvider(type = PlanObtainProvider.class, method = "getDistributedPlanListByParams")
    List<PlanSearchResp> getDistributedPlanListByParams(Map<String, Object> params);

    @SelectProvider(type = PlanObtainProvider.class, method = "getCompletedPlanListByParams")
    List<PlanSearchResp> getCompletedPlanListByParams(Map<String, Object> params);

    @SelectProvider(type = PlanObtainProvider.class, method = "getRootPlanObjectIdByParams")
    List<Integer> getRootPlanObjectIdByParams(Map<String, Object> params);
}
