package org.plan.managementfacade.model.planModel;

import lombok.Data;
import org.plan.managementfacade.model.enumModel.PlanState;

import java.util.List;

@Data
public class Test {
    private String name;
    private String level;
    private List<Test> children = null;
}
