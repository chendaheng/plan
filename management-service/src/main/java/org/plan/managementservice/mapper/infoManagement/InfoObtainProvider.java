package org.plan.managementservice.mapper.infoManagement;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.jdbc.SQL;
import org.plan.managementfacade.model.infoModel.requestModel.*;

public class InfoObtainProvider {
    public String getRangeResponseByCondition (@Param("rangeSearchRequest") RangeSearchRequest rangeSearchRequest) {
        return new SQL() {
            {
                SELECT("*");
                FROM("rangesearch");
                if (rangeSearchRequest.getUserId() != -1){
                    WHERE("userId" + "=" + rangeSearchRequest.getUserId());
                }
                if (rangeSearchRequest.getId() != -1){
                    WHERE("id" + "=" + rangeSearchRequest.getId());
                }
                if (rangeSearchRequest.getCustomerId() != -1){
                    WHERE("customerId" + "=" + rangeSearchRequest.getCustomerId());
                }
                if (rangeSearchRequest.getBrandId() != -1){
                    WHERE("brandId" + "=" + rangeSearchRequest.getBrandId());
                }
                if (rangeSearchRequest.getClothingLevelId() != -1){
                    WHERE("clothingLevelId" + "=" + rangeSearchRequest.getClothingLevelId());
                }
                if (rangeSearchRequest.getStartDate() != null){
                    WHERE("createTime>='" + rangeSearchRequest.getStartDate().toString() + "'");
                }
                if (rangeSearchRequest.getEndDate() != null){
                    WHERE("createTime<='" + rangeSearchRequest.getEndDate().toString() + "'");
                }
            }
        }.toString();
    }

    public String getStyleGroupResponseByCondition (@Param("styleGroupSearchRequest") StyleGroupSearchRequest styleGroupSearchRequest) {
        return new SQL() {
            {
                SELECT("*");
                FROM("stylegroupsearch");
                if (styleGroupSearchRequest.getUserId() != -1){
                    WHERE("userId" + "=" + styleGroupSearchRequest.getUserId());
                }
                if (styleGroupSearchRequest.getId() != -1){
                    WHERE("id" + "=" + styleGroupSearchRequest.getId());
                }
                if (styleGroupSearchRequest.getCustomerId() != -1){
                    WHERE("customerId" + "=" + styleGroupSearchRequest.getCustomerId());
                }
                if (styleGroupSearchRequest.getBrandId() != -1){
                    WHERE("brandId" + "=" + styleGroupSearchRequest.getBrandId());
                }
                if (styleGroupSearchRequest.getRangeId() != -1){
                    WHERE("rangeId" + "=" + styleGroupSearchRequest.getRangeId());
                }
                if (styleGroupSearchRequest.getClothingLevelId() != -1){
                    WHERE("clothingLevelId" + "=" + styleGroupSearchRequest.getClothingLevelId());
                }
                if (styleGroupSearchRequest.getStartDate() != null){
                    WHERE("createTime>='" + styleGroupSearchRequest.getStartDate().toString() + "'");
                }
                if (styleGroupSearchRequest.getEndDate() != null){
                    WHERE("createTime<='" + styleGroupSearchRequest.getEndDate().toString() + "'");
                }
            }
        }.toString();
    }
}
