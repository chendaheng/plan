package org.plan.managementfacade.model.planModel.requestModel;

import lombok.Data;

@Data
public class PlanToTemplateReq {
    private Integer rangeId;
    private String name;
    private String customerName;
    private String brandName;
    private boolean isPublic;
}
