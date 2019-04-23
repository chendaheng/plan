package org.plan.managementservice.mapper.InfoManagement;

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
            }
        }.toString();
    }
}
