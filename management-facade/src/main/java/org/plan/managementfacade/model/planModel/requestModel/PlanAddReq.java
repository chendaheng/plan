package org.plan.managementfacade.model.planModel.requestModel;

import org.plan.managementfacade.model.enumModel.PlanType;
import org.plan.managementfacade.model.planModel.sqlModel.Plan;

public class PlanAddReq {
    private String name;
    private Integer rangeId;
    private PlanType type;
    private boolean isRoot;
    private Integer parentId;
    private Integer planObjectId;
    private String projectType;
    private Integer quantity;
    private Integer productId;
    private String productDate;
    private String productDateType;
    private String startDate;
    private String endDate;
    private String proposal;
    private String description;
    private String note = "";

    public PlanAddReq() {
    }

    public PlanAddReq(Plan plan) {
        name = plan.getName();
        rangeId = plan.getRangeId();
        type = plan.getType();
        isRoot = plan.isRoot();
        parentId = plan.getParentId();
        planObjectId = plan.getPlanObjectId();
        projectType = plan.getProjectType();
        quantity = plan.getQuantity();
        productId = plan.getProductId();
        productDate = plan.getProductDate();
        productDateType = plan.getProductDateType();
        startDate = plan.getStartDate();
        endDate = plan.getEndDate();
        proposal = plan.getProposal();
        description = plan.getDescription();
        note = plan.getNote();
    }

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

    public String getProjectType() {
        return projectType;
    }

    public void setProjectType(String projectType) {
        this.projectType = projectType;
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
