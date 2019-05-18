package org.plan.managementfacade.model.infoModel.sqlModel;

import io.swagger.annotations.ApiModel;

@ApiModel("款式信息模型")
public class Style {
    private Integer id;
    private String number;
    private Integer rangeId;
    private Integer styleGroupId;
    private String styleGroupNumber;
    private String styleGroupName;
    private Integer addingMode;
    private Integer state;
    private Integer createrId;
    private String createrName;
    private String deptName;
    private String createTime;
    private Boolean havePlan;

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

    public Integer getRangeId() {
        return rangeId;
    }

    public void setRangeId(Integer rangeId) {
        this.rangeId = rangeId;
    }

    public Integer getStyleGroupId() {
        return styleGroupId;
    }

    public void setStyleGroupId(Integer styleGroupId) {
        this.styleGroupId = styleGroupId;
    }

    public String getStyleGroupNumber() {
        return styleGroupNumber;
    }

    public void setStyleGroupNumber(String styleGroupNumber) {
        this.styleGroupNumber = styleGroupNumber;
    }

    public String getStyleGroupName() {
        return styleGroupName;
    }

    public void setStyleGroupName(String styleGroupName) {
        this.styleGroupName = styleGroupName;
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

    public Boolean getHavePlan() {
        return havePlan;
    }

    public void setHavePlan(Boolean havePlan) {
        this.havePlan = havePlan;
    }
}
