package org.plan.managementfacade.model.planModel.sqlModel;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PlanInstance {
    private Integer id;
    private Integer planId;
    private Integer instanceId;
    private Integer nodeId;

    public PlanInstance (Integer planId, Integer instanceId, Integer nodeId) {
        this.id = null;
        this.planId = planId;
        this.instanceId = instanceId;
        this.nodeId = nodeId;
    }
}
