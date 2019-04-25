package org.plan.managementfacade.model.infoModel.requestModel;

import io.swagger.annotations.ApiModel;

@ApiModel("新增系列参数模型")
public class RangeAddRequest {
    private String number; // 暂缺自动生成方法 假数据填充
    private String name;
    private int brandId;
    private int clothingLevelId;
    private int addingMode; // 自动添加
    private int createrId; //  用户服务传 假数据填充
    private String createrName; //  用户服务传 假数据填充
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

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
