package org.plan.managementservice.mapper.planManagement;

import org.apache.ibatis.annotations.*;
import org.plan.managementfacade.model.planModel.Plan;
import org.plan.managementfacade.model.planModel.PlanException;
import org.plan.managementfacade.model.planModel.Test;

import java.util.List;

@Mapper
public interface PlanModifyMapper {
    @InsertProvider(type = PlanModifyProvider.class, method = "addPlan")
    int addPlan(Plan plan);

    @Insert("INSERT INTO planexception(number, planId, cause, userName, createTime) VALUES(#{number}, #{planId}, #{cause}, #{userName}, #{createTime});")
    int addExceptionForPlan(PlanException planException);

    @Insert("INSERT INTO plan_user VALUES(#{planId}, #{executerId});")
    int distributePlanToUser(int planId, int executerId);

    @Delete("DELETE FROM plan WHERE id=#{id};")
    int deletePlanById(int id);

    @Insert("INSERT INTO test(id, createTime) VALUES(#{test.id}, #{test.createTime})")
    int addTest(Test test);

    @Select("SELECT * FROM test;")
    List<Test> getTest();
}
