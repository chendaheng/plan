package org.plan.managementfacade.model.infoModel.sqlModel;

import io.swagger.annotations.ApiModel;

@ApiModel("系列信息模型")
public class Range {
    private Integer id;
    private String number;
    private String name;
    private Integer customerId;
    private Integer brandId;
    private Integer clothingLevelId;
    private Integer styleQuantity;
    private Integer addingMode;
    private Integer state;
    private Integer createrId;
    private String createrName;
    private String deptName;
    private String createTime;
    private String note;
    private Boolean havePredictPlan;
    private Boolean havePlan;
    private Boolean isCompleted;

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

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public Integer getBrandId() {
        return brandId;
    }

    public void setBrandId(Integer brandId) {
        this.brandId = brandId;
    }

    public Integer getClothingLevelId() {
        return clothingLevelId;
    }

    public void setClothingLevelId(Integer clothingLevelId) {
        this.clothingLevelId = clothingLevelId;
    }

    public Integer getStyleQuantity() {
        return styleQuantity;
    }

    public void setStyleQuantity(Integer styleQuantity) {
        this.styleQuantity = styleQuantity;
    }

    public Integer getAddingMode() {
        return addingMode;
    }

    public void setAddingMode(Integer addingMode) {
        this.addingMode = addingMode;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
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

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Boolean getHavePredictPlan() {
        return havePredictPlan;
    }

    public void setHavePredictPlan(Boolean havePredictPlan) {
        this.havePredictPlan = havePredictPlan;
    }

    public Boolean getHavePlan() {
        return havePlan;
    }

    public void setHavePlan(Boolean havePlan) {
        this.havePlan = havePlan;
    }

    public Boolean getCompleted() {
        return isCompleted;
    }

    public void setCompleted(Boolean completed) {
        isCompleted = completed;
    }
}
