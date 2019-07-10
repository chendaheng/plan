package org.plan.managementfacade.model.planModel.requestModel;

import lombok.Data;

@Data
public class TemplateToPlanReq {
    private Integer rangeId;
    private Integer quantity;
    private Integer planTemplateId;
}
