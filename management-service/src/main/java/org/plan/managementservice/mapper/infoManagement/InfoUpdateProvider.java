package org.plan.managementservice.mapper.infoManagement;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.jdbc.SQL;
import org.plan.managementfacade.model.infoModel.requestModel.*;

public class InfoUpdateProvider {
    public String updateRange (@Param("rangeUpdateRequest") RangeUpdateRequest rangeUpdateRequest) {
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
}
