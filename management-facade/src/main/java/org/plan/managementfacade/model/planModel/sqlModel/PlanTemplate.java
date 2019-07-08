package org.plan.managementfacade.model.planModel.sqlModel;

import lombok.Data;

@Data
public class PlanTemplate {
    private Integer id;

    private String name;

    private String customerName;

    private String brandName;

    private Integer createrId;

    private String createrName;

    /**
     * 创建时间，以生成记录时为准
     */
    private String createTime;

    /**
     * 默认为false
     */
    private boolean isPublic;

    private TemplateTree tree;
}
