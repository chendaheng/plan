package org.plan.managementservice.mapper.planManagement;

import org.apache.ibatis.jdbc.SQL;
import org.plan.managementfacade.model.planModel.PlanUpdateReq;

public class PlanUpdateProvider {
    public String updatePlan (PlanUpdateReq planUpdateReq) {
        return new SQL() {
            {

            }
        }.toString();
    }
}
