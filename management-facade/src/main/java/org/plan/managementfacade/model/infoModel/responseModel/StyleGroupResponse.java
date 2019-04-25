package org.plan.managementfacade.model.infoModel.responseModel;

import io.swagger.annotations.ApiModel;

import java.sql.Timestamp;

@ApiModel("款式组返回模型")
public class StyleGroupResponse {
    private int id;
    private String number;
    private String name;
    private int rangeId;
    private String rangeNumber; // 待取
    private String rangeName; // 待取
    private int customerId; // 待取
    private String customerName; // 待取
    private int brandId; // 待取
    private String brandName; // 待取
    private int clothingLevelId; //
    private String clothingLevelName; //
    private int createrId;
    private String createrName;
    private String deptName; // 待取
    private Timestamp createTime;

}
