package org.plan.managementservice.mapper.planManagement;

import org.apache.ibatis.annotations.*;
import org.plan.managementfacade.model.planModel.requestModel.PlanTemplateAddReq;
import org.plan.managementfacade.model.planModel.sqlModel.*;
import org.plan.managementfacade.model.planModel.Test;

import java.util.List;

@Mapper
public interface PlanModifyMapper {
    @InsertProvider(type = PlanModifyProvider.class, method = "addPlan")
    @SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "id", before = false, resultType = Integer.class)
    int addPlan(Plan plan);

    @Insert("INSERT INTO plan_files(planId, filename) VALUES(#{planId}, #{filename});")
    void addPlanFile(@Param("planId") Integer planId, @Param("filename") String filename);

    @Insert("INSERT INTO plantemplate(name, customerName, brandName, tree, createrId, createrName) VALUES" +
            "(#{addReq.name}, #{addReq.customerName}, #{addReq.brandName}, #{addReq.tree}, #{createrId}, #{createrName});")
    int addPlanTemplate(@Param("addReq") PlanTemplateAddReq addReq, @Param("createrId") int createrId, @Param("createrName") String createrName);

    @Insert("INSERT INTO plantemplate(name, customerName, brandName, tree, createrId, createrName, is_public) VALUES" +
            "(#{name}, #{customerName}, #{brandName}, #{tree}, #{createrId}, #{createrName}, #{isPublic})")
    int saveToPlanTemplate(@Param("name") String name, @Param("customerName") String customerName, @Param("brandName") String brandName, @Param("tree") TemplateTree tree,
                        @Param("createrId") Integer createrId, @Param("createrName") String createrName, @Param("isPublic") boolean isPublic);

    @Insert("INSERT INTO templateinstance(rangeId, createrName, deptName, tree) VALUES(#{rangeId}, #{createrName}, #{deptName}, #{tree});")
    @SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "id", before = false, resultType = Integer.class)
    void addTemplateInstance(TemplateInstance instance);

    @Insert("INSERT INTO plan_instance(planId, instanceId, nodeId) VALUES(#{planId}, #{instanceId}, #{nodeId});")
    int addPlanInstance(PlanInstance planInstance);

    @Insert("INSERT INTO planexception (number, planId, cause, userName) VALUES(#{number}, #{planId}, #{cause}, #{userName});")
    int addExceptionForPlan(PlanException planException);

    @Insert("INSERT INTO plan_user VALUES(#{planId}, #{executerId});")
    int distributePlanToUser(int planId, int executerId);

    @Delete("DELETE FROM plan WHERE id=#{id};")
    int deletePlanById(int id);

    @Delete("DELETE FROM plan_files WHERE planId=#{planId} AND filename=#{filename};")
    int deletePlanFile(@Param("planId") Integer planId, @Param("filename") String filename);

    @Delete("DELETE FROM plantemplate WHERE id=#{id};")
    int deletePlanTemplateById(@Param("id") Integer id);

    @Insert("INSERT INTO test(id, createTime) VALUES(#{test.id}, #{test.createTime})")
    int addTest(Test test);

    @Select("SELECT * FROM test;")
    List<Test> getTest();
}
