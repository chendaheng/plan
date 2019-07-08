package org.plan.managementfacade.model.planModel.requestModel;

import lombok.Data;
import org.plan.managementfacade.model.planModel.sqlModel.TemplateTree;

@Data
public class PlanTemplateUpdateReqq {
    private Integer id;
    private String name;
    private String customerName;
    private String brandName;
    private TemplateTree tree;
}
