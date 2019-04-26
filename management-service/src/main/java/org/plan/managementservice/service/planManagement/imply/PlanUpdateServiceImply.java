package org.plan.managementservice.service.planManagement.imply;

import org.plan.managementfacade.model.enumModel.State;
import org.plan.managementservice.general.ErrorCode;
import org.plan.managementservice.mapper.planManagement.PlanUpdateMapper;
import org.plan.managementservice.mapper.planManagement.PlanObtainMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PlanUpdateServiceImply {
    @Autowired
    private PlanObtainMapper planObtainMapper;
    @Autowired
    private PlanUpdateMapper planUpdateMapper;

    public int deletePlan(int id, int state) {
        int planState = planObtainMapper.getPlanStateById(id);
        if (planState != State.getIndex("已制定")) {
            return ErrorCode.illegalOperation;
        } else {
            return planUpdateMapper.updatePlanState(id, state);
        }
    }

    public int restorePlan(int id, int state) {
        int planState = planObtainMapper.getPlanStateById(id);
        if (planState != State.getIndex("已删除")) {
            return ErrorCode.illegalOperation;
        } else {
            return planUpdateMapper.updatePlanState(id, state);
        }
    }
}
