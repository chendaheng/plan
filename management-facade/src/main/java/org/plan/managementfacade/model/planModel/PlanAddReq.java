package org.plan.managementfacade.model.planModel;

import org.plan.managementfacade.model.enumModel.PlanType;
import org.plan.managementfacade.model.enumModel.ProjectType;

public class PlanAddReq {
    private String name;
    private Integer rangeId;
    private PlanType type;
    private boolean isRoot;
    private Integer parentId;
    private Integer planObjectId;
    private ProjectType projectType;
    private Integer quantity;
    private Integer productId;
    private String productDate;
    private String productDateType;
    private String startDate;
    private String endDate;
    private String proposal;
    private String description;
    private String note = "";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getRangeId() {
        return rangeId;
    }

    public void setRangeId(Integer rangeId) {
        this.rangeId = rangeId;
    }

    public PlanType getType() {
        return type;
    }

    public void setType(PlanType type) {
        this.type = type;
    }

    public void setType(String name) {
        this.type = PlanType.getPlanType(name);
    }

    public boolean isRoot() {
        return isRoot;
    }

    public void setIsRoot(boolean root) {
        isRoot = root;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public Integer getPlanObjectId() {
        return planObjectId;
    }

    public void setPlanObjectId(Integer planObjectId) {
        this.planObjectId = planObjectId;
    }

    public ProjectType getProjectType() {
        return projectType;
    }

    public void setProjectType(ProjectType projectType) {
        this.projectType = projectType;
    }

    public void setProjectType(String name) {
        this.projectType = ProjectType.getProjectType(name);
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getProductDate() {
        return productDate;
    }

    public void setProductDate(String productDate) {
        this.productDate = productDate;
    }

    public String getProductDateType() {
        return productDateType;
    }

    public void setProductDateType(String productDateType) {
        this.productDateType = productDateType;
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

    public String getProposal() {
        return proposal;
    }

    public void setProposal(String proposal) {
        this.proposal = proposal;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
