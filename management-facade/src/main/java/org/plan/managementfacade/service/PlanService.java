package org.plan.managementfacade.service;

import org.plan.managementfacade.model.WarehouseStockInPlan;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public interface PlanService {
    List <WarehouseStockInPlan> getData();
}
