package org.plan.managementservice.mapper.infoManagement;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.jdbc.SQL;
import org.plan.managementfacade.model.infoModel.requestModel.*;

public class InfoObtainProvider {
    public String getRangeResponseByCondition (@Param("rangeSearchRequest") RangeSearchRequest rangeSearchRequest) {
        return new SQL() {
            {
                SELECT("`range`.*, customer.name as customerName, brand.name as brandName, clothingLevel.name as clothingLevelName");
                FROM("`range`, customer, brand, clothingLevel");
                WHERE("range.customerId = customer.id and range.brandId = brand.id and range.clothingLevelId = clothingLevel.id");
                if (rangeSearchRequest.getId() != -1){
                    WHERE("range.id" + "=" + rangeSearchRequest.getId());
                }
                if (rangeSearchRequest.getCustomerId() != -1){
                    WHERE("range.customerId" + "=" + rangeSearchRequest.getCustomerId());
                }
                if (rangeSearchRequest.getBrandId() != -1){
                    WHERE("range.brandId" + "=" + rangeSearchRequest.getBrandId());
                }
                if (rangeSearchRequest.getClothingLevelId() != -1){
                    WHERE("range.clothingLevelId" + "=" + rangeSearchRequest.getClothingLevelId());
                }
                if (rangeSearchRequest.getStartDate() != null){
                    WHERE("range.createTime>='" + rangeSearchRequest.getStartDate().toString() + "'");
                }
                if (rangeSearchRequest.getEndDate() != null){
                    WHERE("range.createTime<='" + rangeSearchRequest.getEndDate().toString() + "'");
                }
            }
        }.toString();
    }
}
