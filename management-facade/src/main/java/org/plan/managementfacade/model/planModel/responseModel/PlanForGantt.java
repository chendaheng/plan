package org.plan.managementfacade.model.planModel.responseModel;

public class PlanForGantt {
    private Integer id;
    private String name;
    private Integer parentId;
    private String projectType;
    private Integer order;
    private Integer quantity;
    private String startDate;
    private String endDate;
    private String createrName;
    private boolean isRoot;
    private boolean haveException;

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

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
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

    public boolean getIsRoot() {
        return isRoot;
    }

    public void setIsRoot (boolean isRoot) {
        this.isRoot = isRoot;
    }

    public boolean isHaveException() {
        return haveException;
    }

    public void setHaveException(boolean haveException) {
        this.haveException = haveException;
    }
}
