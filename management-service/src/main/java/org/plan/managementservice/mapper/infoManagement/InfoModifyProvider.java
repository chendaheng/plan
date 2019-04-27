package org.plan.managementservice.mapper.infoManagement;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.jdbc.SQL;
import org.plan.managementfacade.model.infoModel.requestModel.*;


public class InfoModifyProvider {
    public String addRange (@Param("rangeAddRequest") RangeAddRequest rangeAddRequest){
        // 新增系列
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
                VALUES("deptName", "'" + rangeAddRequest.getDeptName() + "'");
                if (rangeAddRequest.getNote() != null){
                    VALUES("note", "'" + rangeAddRequest.getNote() + "'");
                }
            }
        }.toString();
    }

    public String addStyleGroup (@Param("styleGroupAddRequest") StyleGroupAddRequest styleGroupAddRequest){
        // 新增款式组
        return new SQL() {
            {
                INSERT_INTO("stylegroup");
                VALUES("number", "'" + styleGroupAddRequest.getNumber() + "'");
                VALUES("name", "'" + styleGroupAddRequest.getName() + "'");
                VALUES("rangeId", Integer.toString(styleGroupAddRequest.getRangeId()));
                VALUES("createrId ", Integer.toString(styleGroupAddRequest.getCreaterId()));
                VALUES("createrName", "'" + styleGroupAddRequest.getCreaterName() + "'");
                VALUES("deptName", "'" + styleGroupAddRequest.getDeptName() + "'");
            }
        }.toString();
    }

    public String addStyle (@Param("styleAddRequest") StyleAddRequest styleAddRequest){
        // 新增款式
        return new SQL() {
            {
                INSERT_INTO("style");
                VALUES("number", "'" + styleAddRequest.getNumber() + "'");
                VALUES("rangeId", Integer.toString(styleAddRequest.getRangeId()));
                VALUES("addingMode ", Integer.toString(styleAddRequest.getAddingMode()));
                VALUES("createrId ", Integer.toString(styleAddRequest.getCreaterId()));
                VALUES("createrName", "'" + styleAddRequest.getCreaterName() + "'");
                VALUES("deptName", "'" + styleAddRequest.getDeptName() + "'");
            }
        }.toString();
    }
}
