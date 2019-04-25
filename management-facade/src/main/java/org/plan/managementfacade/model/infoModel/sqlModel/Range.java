package org.plan.managementfacade.model.infoModel.sqlModel;

import io.swagger.annotations.ApiModel;
import java.sql.Timestamp;

@ApiModel("系列信息模型")
public class Range {
    private int id;
    private String number;
    private String name;
    private int customerId;
    private int brandId;
    private int clothingLevelId;
    private int styleQuantity;
    private int addingMode;
    private int state;
    private int createrId;
    private String createrName;
    private String deptName;
    private Timestamp createTime;
    private String note;
    private Boolean havePredictPlan;
    private Boolean havePlan;
    private Boolean isCompleted;

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getBrandId() {
        return brandId;
    }

    public void setBrandId(int brandId) {
        this.brandId = brandId;
    }

    public int getClothingLevelId() {
        return clothingLevelId;
    }

    public void setClothingLevelId(int clothingLevelId) {
        this.clothingLevelId = clothingLevelId;
    }

    public int getStyleQuantity() {
        return styleQuantity;
    }

    public void setStyleQuantity(int styleQuantity) {
        this.styleQuantity = styleQuantity;
    }

    public int getAddingMode() {
        return addingMode;
    }

    public void setAddingMode(int addingMode) {
        this.addingMode = addingMode;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public int getCreaterId() {
        return createrId;
    }

    public void setCreaterId(int createrId) {
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

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
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
