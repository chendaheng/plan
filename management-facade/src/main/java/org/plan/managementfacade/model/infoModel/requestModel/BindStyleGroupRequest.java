package org.plan.managementfacade.model.infoModel.requestModel;

import io.swagger.annotations.ApiModel;

import java.util.List;

@ApiModel("绑定款式组参数模型")
public class BindStyleGroupRequest {

    private int styleGroupId = -1;
    private String styleGroupNumber = null;
    private String styleGroupName = null;
    private String styleNumber = null;

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

    public String getStyleNumber() {
        return styleNumber;
    }

    public void setStyleNumber(String styleNumber) {
        this.styleNumber = styleNumber;
    }
}
