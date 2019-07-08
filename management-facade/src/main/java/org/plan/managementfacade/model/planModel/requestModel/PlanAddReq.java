package org.plan.managementfacade.model.planModel.requestModel;

import org.plan.managementfacade.model.enumModel.PlanType;
import org.plan.managementfacade.model.planModel.sqlModel.Plan;

import java.sql.Date;
import java.util.Calendar;

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

    // 此构造函数用于引用模板生成计划
    public PlanAddReq(String name, Integer rangeId, PlanType type, boolean isRoot, Integer parentId, Integer planObjectId, Integer quantity) {
        // 对于模板生成的计划，默认初始化时将其开始结束日期均设为当年的第一天（方便查看人员发现问题）
        Calendar calendar = Calendar.getInstance();
        String date = calendar.get(Calendar.YEAR) + "-01-01";
        this.name = name;
        this.rangeId = rangeId;
        this.type = type;
        this.isRoot = isRoot;
        this.parentId = parentId;
        this.planObjectId = planObjectId;
        this.projectType = "";
        this.quantity = quantity;
        // productId在数据库中与product表建立了外键关联，因此必须有值，默认给予1
        this.productId = 1;
        this.productDate = "";
        this.productDateType = "";
        this.startDate = date;
        this.endDate = date;
        this.proposal = "";
        this.description = "";
        this.note = "";
    }

    public PlanAddReq(Plan plan) {
        name = plan.getName();
        rangeId = plan.getRangeId();
        type = plan.getType();
        isRoot = plan.getIsRoot();
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

    public boolean getIsRoot() {
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
