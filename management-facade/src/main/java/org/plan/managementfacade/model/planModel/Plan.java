package org.plan.managementfacade.model.planModel;

import org.plan.managementfacade.model.enumModel.PlanState;
import org.plan.managementfacade.model.enumModel.PlanType;
import org.plan.managementfacade.model.enumModel.ProjectType;

public class Plan {
    private Integer id;
    private String number;
    private String name;
    private Integer rangeId;
    private PlanType type;
    private boolean isRoot;
    private Integer parentId;
    private Integer planObjectId;
    private ProjectType projectType;
    private Integer order;
    private Integer quantity;
    private Integer productId;
    private String productDate;
    private String productDateType;
    private String startDate;
    private String endDate;
    private String proposal;
    private String description;
    private PlanState state;
    private Integer createrId;
    private String createrName;
    private String createTime;
    private String rejectReason;
    private String deleteTime;
    private boolean haveException;
    private String note;

    public Plan (PlanAddReq planAddReq) {
        name = planAddReq.getName();
        rangeId = planAddReq.getRangeId();
        type = planAddReq.getType();
        isRoot = planAddReq.isRoot();
        parentId = planAddReq.getParentId();
        planObjectId = planAddReq.getPlanObjectId();
        projectType = planAddReq.getProjectType();
        quantity = planAddReq.getQuantity();
        productId = planAddReq.getProductId();
        productDate = planAddReq.getProductDate();
        productDateType = planAddReq.getProductDateType();
        startDate = planAddReq.getStartDate();
        endDate = planAddReq.getEndDate();
        proposal = planAddReq.getProposal();
        description = planAddReq.getDescription();
        note = planAddReq.getNote();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
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

    public void setIsRoot(boolean isRoot) {
        isRoot = isRoot;
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

    public PlanState getState() {
        return state;
    }

    public void setState(PlanState state) {
        this.state = state;
    }

    public void setState(String name) {
        this.state = PlanState.getPlanState(name);
    }

    public Integer getCreaterId() {
        return createrId;
    }

    public void setCreaterId(Integer createrId) {
        this.createrId = createrId;
    }

    public String getCreaterName() {
        return createrName;
    }

    public void setCreaterName(String createrName) {
        this.createrName = createrName;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getRejectReason() {
        return rejectReason;
    }

    public void setRejectReason(String rejectReason) {
        this.rejectReason = rejectReason;
    }

    public String getDeleteTime() {
        return deleteTime;
    }

    public void setDeleteTime(String deleteTime) {
        this.deleteTime = deleteTime;
    }

    public boolean isHaveException() {
        return haveException;
    }

    public void setHaveException(boolean haveException) {
        this.haveException = haveException;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
