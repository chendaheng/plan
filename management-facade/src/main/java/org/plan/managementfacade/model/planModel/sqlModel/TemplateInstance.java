package org.plan.managementfacade.model.planModel.sqlModel;

import lombok.Data;

@Data
public class TemplateInstance {
    private Integer id;
    private Integer rangeId;
    private String createrName;
    private String deptName;
    private TemplateTree tree;

    public TemplateInstance() {
    }

    public TemplateInstance(Integer rangeId, String createrName, String deptName, TemplateTree tree) {
        this.rangeId = rangeId;
        this.createrName = createrName;
        this.deptName = deptName;
        this.tree = tree;
    }
}
