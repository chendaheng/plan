package org.plan.managementservice.mapper.infoManagement;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.jdbc.SQL;
import org.plan.managementfacade.model.infoModel.requestModel.*;


public class InfoModifyProvider {
    public String addRange (@Param("rangeAddRequest") RangeAddRequest rangeAddRequest){
        return new SQL() {
            {
                INSERT_INTO("range");
                VALUES("name", "'" + rangeAddRequest.getName() + "'");
                VALUES("customerId", Integer.toString(rangeAddRequest.getCustomerId()));
                VALUES("brandId", Integer.toString(rangeAddRequest.getBrandId()));
                VALUES("clothingLevelId ", Integer.toString(rangeAddRequest.getClothingLevelId()));
                if (rangeAddRequest.getNote() != null){
                    VALUES("note", "'" + rangeAddRequest.getNote() + "'");
                }
            }
        }.toString();
    }
}
