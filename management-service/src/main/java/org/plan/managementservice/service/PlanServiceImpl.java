package org.plan.managementservice.service;

import org.plan.managementfacade.model.WarehouseStockInPlan;
import org.plan.managementfacade.service.PlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.plan.managementservice.mapper.*;
import java.util.List;

@Component
public class PlanServiceImpl implements PlanService {

    @Autowired
    private PlanMapper planMapper;

    @Override
    public List<WarehouseStockInPlan> getData() {
        return planMapper.getData();
    }
}
