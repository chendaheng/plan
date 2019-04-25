package org.plan.managementservice.mapper.infoManagement;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.jdbc.SQL;
import org.plan.managementfacade.model.infoModel.requestModel.*;


public class InfoModifyProvider {
    public String addRange (@Param("rangeAddRequest") RangeAddRequest rangeAddRequest){
        return new SQL() {
            {
                INSERT_INTO("`range`");
                VALUES("number", "'" + rangeAddRequest.getNumber() + "'");
                VALUES("name", "'" + rangeAddRequest.getName() + "'");
                VALUES("brandId", Integer.toString(rangeAddRequest.getBrandId()));
                VALUES("clothingLevelId ", Integer.toString(rangeAddRequest.getClothingLevelId()));
                VALUES("addingMode ", Integer.toString(rangeAddRequest.getAddingMode()));
                VALUES("createrId ", Integer.toString(rangeAddRequest.getCreaterId()));
                VALUES("createrName", "'" + rangeAddRequest.getCreaterName() + "'");
                if (rangeAddRequest.getNote() != null){
                    VALUES("note", "'" + rangeAddRequest.getNote() + "'");
                }
            }
        }.toString();
    }
}
