package org.plan.managementservice.mapper.infoManagement;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.plan.managementfacade.model.infoModel.requestModel.*;

@Mapper
public interface InfoUpdateMapper {

    // 更新系列信息
    @UpdateProvider(type = InfoUpdateProvider.class, method = "updateRange")
    int updateRange (@Param("rangeUpdateRequest") RangeUpdateRequest rangeUpdateRequest);

    // 更新款式组信息
    @UpdateProvider(type = InfoUpdateProvider.class, method = "updateStyleGroup")
    int updateStyleGroup (@Param("styleGroupUpdateRequest") StyleGroupUpdateRequest styleGroupUpdateRequest);

    // 更新款式信息
    @UpdateProvider(type = InfoUpdateProvider.class, method = "updateStyle")
    int updateStyle (@Param("styleUpdateRequest") StyleUpdateRequest styleUpdateRequest);

    @Update("UPDATE `range` SET havePredictPlan=#{bool} WHERE id=#{id};")
    void updateRangeHavePredictPlanById(@Param("id") int id, @Param("bool") boolean bool);

    @Update("UPDATE `range` SET havePlan=#{bool} WHERE id=#{id};")
    void updateRangeHavePlanById(@Param("id") int id, @Param("bool") boolean bool);

    @Update("UPDATE styleGroup SET havePlan=#{bool} WHERE id=#{id};")
    void updateStyleGroupHavePlanById(@Param("id") int id, @Param("bool") boolean bool);

    @Update("UPDATE style SET havePlan=#{bool} WHERE id=#{id};")
    void updateStyleHavePlanById(@Param("id") int id, @Param("bool") boolean bool);

    @Update("UPDATE `range` SET getIsCompleted=true WHERE id=#{id};")
    int completeRangeById(@Param("id") int id);
}
