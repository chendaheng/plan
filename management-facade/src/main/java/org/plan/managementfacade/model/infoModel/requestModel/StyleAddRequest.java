package org.plan.managementfacade.model.infoModel.requestModel;

import io.swagger.annotations.ApiModel;

@ApiModel("新增款式参数模型")
public class StyleAddRequest {
    private String number;
    private int rangeId;
    private int addingMode; // 自动添加
    private int createrId; //  用户服务传 假数据填充
    private String createrName; //  用户服务传 假数据填充
    private String deptName; //  用户服务传 假数据填充

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

    public int getAddingMode() {
        return addingMode;
    }

    public void setAddingMode(int addingMode) {
        this.addingMode = addingMode;
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
}
