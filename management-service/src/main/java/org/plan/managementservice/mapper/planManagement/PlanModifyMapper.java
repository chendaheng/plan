package org.plan.managementservice.mapper.planManagement;

import org.apache.ibatis.annotations.*;
import org.plan.managementfacade.model.planModel.Plan;
import org.plan.managementfacade.model.planModel.Test;

import java.util.List;

@Mapper
public interface PlanModifyMapper {
//    @Insert("INSERT INTO plan(number, name, rangeId, type, level, parentLevel, planObjectId, projectType, quantity, productId, " +
//            "productDate, productDateType, startDate, endDate, proposal, description, state, createrId, createrName, note) " +
//            "VALUES(#{number}, #{name}, #{rangeId}, #{type}, 1, 0, #{planObjectId}, #{projectType}, #{quantity}, #{productId}, " +
//            "#{productDate}, #{productDateType}, #{startDate}, #{endDate}, #{proposal}, #{description}, #{state}, #{createrId}, " +
//            "#{createrName}, #{note})")
    @InsertProvider(type = PlanModifyProvider.class, method = "addPlan")
    int addPlan(Plan plan);

    @Delete("DELETE FROM plan WHERE id=#{id};")
    int deletePlanById(int id);

    @Insert("INSERT INTO test(id, createTime) VALUES(#{test.id}, #{test.createTime})")
    int addTest(Test test);

    @Select("SELECT * FROM test;")
    List<Test> getTest();
}
