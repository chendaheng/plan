package org.plan.managementfacade.model.baseInfoModel.sqlModel;

import io.swagger.annotations.ApiModel;

@ApiModel("编号自动生成规则")
public class SerialNoRegular {
    private Integer id;
    private String numberObject;
    private String numberPrefix;
    private Integer numberLength;
    private Integer lastNumberLength;
    private Boolean afterChangeGenerate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumberObject() {
        return numberObject;
    }

    public void setNumberObject(String numberObject) {
        this.numberObject = numberObject;
    }

    public String getNumberPrefix() {
        return numberPrefix;
    }

    public void setNumberPrefix(String numberPrefix) {
        this.numberPrefix = numberPrefix;
    }

    public Integer getNumberLength() {
        return numberLength;
    }

    public void setNumberLength(Integer numberLength) {
        this.numberLength = numberLength;
    }

    public Integer getLastNumberLength() {
        return lastNumberLength;
    }

    public void setLastNumberLength(Integer lastNumberLength) {
        this.lastNumberLength = lastNumberLength;
    }

    public Boolean getAfterChangeGenerate() {
        return afterChangeGenerate;
    }

    public void setAfterChangeGenerate(Boolean afterChangeGenerate) {
        this.afterChangeGenerate = afterChangeGenerate;
    }
}
