package org.plan.managementfacade.model.planModel.requestModel;

import org.plan.managementfacade.model.planModel.sqlModel.Plan;

import java.util.List;

public class PlanTreeForGantt {
    private Integer id;
    private String name;
    private String projectType;
    private Integer order;
    private Integer quantity;
    private String startDate;
    private String endDate;
    private String createrName;
    private boolean haveException;
    private List<PlanTreeForGantt> children;

    public PlanTreeForGantt(Plan plan) {
        this.id = plan.getId();
        this.name = plan.getName();
        this.projectType = plan.getProjectType();
        this.order = plan.getOrder();
        this.quantity = plan.getQuantity();
        this.startDate = plan.getStartDate();
        this.endDate = plan.getEndDate();
        this.createrName = plan.getCreaterName();
        this.haveException = plan.isHaveException();
        this.children = null;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProjectType() {
        return projectType;
    }

    public void setProjectType(String projectType) {
        this.projectType = projectType;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getCreaterName() {
        return createrName;
    }

    public void setCreaterName(String createrName) {
        this.createrName = createrName;
    }

    public boolean isHaveException() {
        return haveException;
    }

    public void setHaveException(boolean haveException) {
        this.haveException = haveException;
    }

    public List<PlanTreeForGantt> getChildren() {
        return children;
    }

    public void setChildren(List<PlanTreeForGantt> children) {
        this.children = children;
    }

    public void addChildren (PlanTreeForGantt child) {
        this.children.add(child);
    }
}
