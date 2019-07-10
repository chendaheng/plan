package org.plan.managementfacade.model.planModel.sqlModel;

import lombok.Data;

@Data
public class PlanForTemplate {
    private Integer id;
    private String name;
    private Integer parentId;
}
