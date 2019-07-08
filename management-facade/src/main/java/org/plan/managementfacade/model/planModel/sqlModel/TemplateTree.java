package org.plan.managementfacade.model.planModel.sqlModel;

import lombok.Data;

import java.util.List;

@Data
public class TemplateTree {
    private Integer id;
    private String planName;
    private List<TemplateTree> children;
}
