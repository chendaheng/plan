package org.plan.managementfacade.model.infoModel.requestModel;

import io.swagger.annotations.ApiModel;

@ApiModel("新增款式组参数模型")
public class StyleGroupAddRequest {

    private String number; // 暂缺自动生成方法 假数据填充
    private String name;
    private Integer rangeId;
    private Integer createrId; //  用户服务传 假数据填充
    private String createrName; //  用户服务传 假数据填充
    private String deptName; //  用户服务传 假数据填充
    private String note;

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

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
