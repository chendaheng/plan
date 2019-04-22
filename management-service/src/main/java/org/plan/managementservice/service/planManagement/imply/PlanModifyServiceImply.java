package org.plan.managementservice.service.planManagement.imply;

import org.plan.managementfacade.model.enumModel.State;
import org.plan.managementservice.mapper.planManagement.PlanModifyMapper;
import org.plan.managementservice.mapper.planManagement.PlanObtainMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PlanModifyServiceImply {
    @Autowired
    private PlanObtainMapper planObtainMapper;
    @Autowired
    private PlanModifyMapper planModifyMapper;

    private static final int ERROR = -1;

    public int modifyPlan(int id, int state) {
        int planState = planObtainMapper.getPlanStateById(id);

        if (planState != State.getIndex("已删除")) {
            return ERROR;
        } else {
            return planModifyMapper.updatePlanState(id, state);
        }
    }

}
