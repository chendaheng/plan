package org.plan.managementfacade.model.infoModel.requestModel;

import io.swagger.annotations.ApiModel;

@ApiModel("更新款式信息参数模型")
public class StyleUpdateRequest {
    private Integer id;
    private String number;
    private Integer rangeId;
    private Integer state;
    private Integer styleGroupId;
    private String styleGroupNumber;
    private String styleGroupName;

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

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
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
}
