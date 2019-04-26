package org.plan.managementservice.mapper.infoManagement;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.jdbc.SQL;
import org.plan.managementfacade.model.infoModel.requestModel.*;

public class InfoUpdateProvider {
    public String updateRange (@Param("rangeUpdateRequest") RangeUpdateRequest rangeUpdateRequest) {
        // 更新系列
        return new SQL() {
            {
                UPDATE("`range`");
                if (rangeUpdateRequest.getName() != null){
                    SET("name" + "='" + rangeUpdateRequest.getName() + "'");
                }
                if (rangeUpdateRequest.getCustomerId() != -1){
                    SET("customerId" + "=" + rangeUpdateRequest.getCustomerId());
                }
                if (rangeUpdateRequest.getBrandId() != -1){
                    SET("brandId" + "=" + rangeUpdateRequest.getBrandId());
                }
                if (rangeUpdateRequest.getClothingLevelId() != -1){
                    SET("clothingLevelId" + "=" + rangeUpdateRequest.getClothingLevelId());
                }
                if (rangeUpdateRequest.getNote() != null){
                    SET("note" + "='" + rangeUpdateRequest.getNote() + "'");
                }
                WHERE("id" + "=" + rangeUpdateRequest.getId());
            }
        }.toString();
    }

    public String updateStyleGroup (@Param("styleGroupUpdateRequest") StyleGroupUpdateRequest styleGroupUpdateRequest) {
        // 更新款式组
        return new SQL() {
            {
                UPDATE("stylegroup");
                if (styleGroupUpdateRequest.getName() != null){
                    SET("name" + "='" + styleGroupUpdateRequest.getName() + "'");
                }
                if (styleGroupUpdateRequest.getRangeId() != -1){
                    SET("rangeId" + "=" + styleGroupUpdateRequest.getRangeId());
                }
                if (styleGroupUpdateRequest.getState() != -1){
                    SET("state" + "=" + styleGroupUpdateRequest.getState());
                }
                WHERE("id" + "=" + styleGroupUpdateRequest.getId());
            }
        }.toString();
    }

    public String updateStyle (@Param("styleUpdateRequest") StyleUpdateRequest styleUpdateRequest) {
        // 更新款式
        return new SQL() {
            {
                UPDATE("style");
                if (styleUpdateRequest.getNumber() != null){
                    SET("number" + "='" + styleUpdateRequest.getNumber() + "'");
                }
                if (styleUpdateRequest.getRangeId() != -1){
                    SET("rangeId" + "=" + styleUpdateRequest.getRangeId());
                }
                if (styleUpdateRequest.getState() != -1){
                    SET("state" + "=" + styleUpdateRequest.getState());
                }
                if (styleUpdateRequest.getStyleGroupId() != -1){
                    SET("styleGroupId" + "=" + styleUpdateRequest.getStyleGroupId());
                }
                if (styleUpdateRequest.getStyleGroupNumber() != null){
                    SET("styleGroupNumber" + "='" + styleUpdateRequest.getStyleGroupNumber() + "'");
                }
                if (styleUpdateRequest.getStyleGroupName() != null){
                    SET("styleGroupName" + "='" + styleUpdateRequest.getStyleGroupName() + "'");
                }
                WHERE("id" + "=" + styleUpdateRequest.getId());
            }
        }.toString();
    }

}