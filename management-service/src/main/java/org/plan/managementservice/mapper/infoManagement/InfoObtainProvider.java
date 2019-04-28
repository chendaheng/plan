package org.plan.managementservice.mapper.infoManagement;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.jdbc.SQL;
import org.plan.managementfacade.model.infoModel.requestModel.*;

public class InfoObtainProvider {
    public String getRangeResponseByCondition (@Param("rangeSearchRequest") RangeSearchRequest rangeSearchRequest) {
        // 获取系列
        return new SQL() {
            {
                SELECT("*");
                FROM("rangesearch");
                if (rangeSearchRequest.getUserId() != null){
                    WHERE("userId" + "=" + rangeSearchRequest.getUserId());
                }
                if (rangeSearchRequest.getId() != null){
                    WHERE("id" + "=" + rangeSearchRequest.getId());
                }
                if (rangeSearchRequest.getCustomerId() != null){
                    WHERE("customerId" + "=" + rangeSearchRequest.getCustomerId());
                }
                if (rangeSearchRequest.getBrandId() != null){
                    WHERE("brandId" + "=" + rangeSearchRequest.getBrandId());
                }
                if (rangeSearchRequest.getClothingLevelId() != null){
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
        // 获取款式组
        return new SQL() {
            {
                SELECT("*");
                FROM("stylegroupsearch");
                if (styleGroupSearchRequest.getUserId() != null){
                    WHERE("userId" + "=" + styleGroupSearchRequest.getUserId());
                }
                if (styleGroupSearchRequest.getId() != null){
                    WHERE("id" + "=" + styleGroupSearchRequest.getId());
                }
                if (styleGroupSearchRequest.getCustomerId() != null){
                    WHERE("customerId" + "=" + styleGroupSearchRequest.getCustomerId());
                }
                if (styleGroupSearchRequest.getBrandId() != null){
                    WHERE("brandId" + "=" + styleGroupSearchRequest.getBrandId());
                }
                if (styleGroupSearchRequest.getRangeId() != null){
                    WHERE("rangeId" + "=" + styleGroupSearchRequest.getRangeId());
                }
                if (styleGroupSearchRequest.getClothingLevelId() != null){
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

    public String getStyleResponseByCondition (@Param("styleSearchRequest") StyleSearchRequest styleSearchRequest) {
        // 获取款式
        return new SQL() {
            {
                SELECT("*");
                FROM("stylesearch");
                if (styleSearchRequest.getUserId() != null){
                    WHERE("userId" + "=" + styleSearchRequest.getUserId());
                }
                if (styleSearchRequest.getId() != null){
                    WHERE("id" + "=" + styleSearchRequest.getId());
                }
                if (styleSearchRequest.getNumber() != null){
                    WHERE("number='" + styleSearchRequest.getNumber() + "'");
                }
                if (styleSearchRequest.getCustomerId() != null){
                    WHERE("customerId" + "=" + styleSearchRequest.getCustomerId());
                }
                if (styleSearchRequest.getBrandId() != null){
                    WHERE("brandId" + "=" + styleSearchRequest.getBrandId());
                }
                if (styleSearchRequest.getRangeId() != null){
                    WHERE("rangeId" + "=" + styleSearchRequest.getRangeId());
                }
                if (styleSearchRequest.getClothingLevelId() != null){
                    WHERE("clothingLevelId" + "=" + styleSearchRequest.getClothingLevelId());
                }
                if (styleSearchRequest.getStartDate() != null){
                    WHERE("createTime>='" + styleSearchRequest.getStartDate().toString() + "'");
                }
                if (styleSearchRequest.getEndDate() != null){
                    WHERE("createTime<='" + styleSearchRequest.getEndDate().toString() + "'");
                }
            }
        }.toString();
    }
}
