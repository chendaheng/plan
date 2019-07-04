package org.plan.managementservice.mapper.planManagement;

import org.apache.ibatis.annotations.*;
import org.plan.managementfacade.model.planModel.sqlModel.Plan;
import org.plan.managementfacade.model.planModel.sqlModel.PlanException;
import org.plan.managementfacade.model.planModel.Test;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Mapper
public interface PlanModifyMapper {
    @InsertProvider(type = PlanModifyProvider.class, method = "addPlan")
    @SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "id", before = false, resultType = Integer.class)
    int addPlan(Plan plan);

    @Insert("INSERT INTO `plan_files`(planId, filename) VALUES(#{planId}, #{filename});")
    void addPlanFile(@Param("planId") Integer planId, @Param("filename") String filename);

    @Insert("INSERT INTO planexception (number, planId, cause, userName) VALUES(#{number}, #{planId}, #{cause}, #{userName});")
    int addExceptionForPlan(PlanException planException);

    @Insert("INSERT INTO plan_user VALUES(#{planId}, #{executerId});")
    int distributePlanToUser(int planId, int executerId);

    @Delete("DELETE FROM plan WHERE id=#{id};")
    int deletePlanById(int id);

    @Delete("DELETE FROM plan_files WHERE planId=#{planId} AND filename=#{filename};")
    int deletePlanFile(@Param("planId") Integer planId, @Param("filename") String filename);

    @Insert("INSERT INTO test(id, createTime) VALUES(#{test.id}, #{test.createTime})")
    int addTest(Test test);

    @Select("SELECT * FROM test;")
    List<Test> getTest();
}
