package org.plan.managementfacade.model.infoModel.requestModel;

import io.swagger.annotations.ApiModel;

@ApiModel("更新款式信息参数模型")
public class StyleUpdateRequest {
    private int id = -1;
    private String number = null;
    private int rangeId = -1;
    private int state = -1;
    private int styleGroupId = -1;
    private String styleGroupNumber = null;
    private String styleGroupName = null;

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

    public int getRangeId() {
        return rangeId;
    }

    public void setRangeId(int rangeId) {
        this.rangeId = rangeId;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public int getStyleGroupId() {
        return styleGroupId;
    }

    public void setStyleGroupId(int styleGroupId) {
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
