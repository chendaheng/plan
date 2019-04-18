package org.plan.managementservice.mapper;

import org.apache.ibatis.annotations.*;
import java.util.List;
import java.util.Map;
import org.plan.managementfacade.model.*;

@Mapper
public interface PlanMapper {

    @Select("SELECT * FROM warehousestockinplan")
    List <WarehouseStockInPlan> getData ();
}
