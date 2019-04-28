package org.plan.managementfacade.model.infoModel.requestModel;

import io.swagger.annotations.ApiModel;
import io.swagger.models.auth.In;

@ApiModel("新增款式参数模型")
public class StyleAddRequest {
    private String number;
    private Integer rangeId;
    private Integer addingMode; // 自动添加
    private Integer createrId; //  用户服务传 假数据填充
    private String createrName; //  用户服务传 假数据填充
    private String deptName; //  用户服务传 假数据填充

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

    public Integer getAddingMode() {
        return addingMode;
    }

    public void setAddingMode(Integer addingMode) {
        this.addingMode = addingMode;
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
}
