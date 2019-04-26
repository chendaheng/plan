package org.plan.managementservice.mapper.authorityManagement;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.jdbc.SQL;
import org.plan.managementfacade.model.authorityModel.AuthorityReq;

public class AuthorityObtainProvider {
    public String getUserDataAuthorityByParams (@Param("authorityReq") AuthorityReq authorityReq) {
        SQL sql = new SQL();
        sql.SELECT("*").FROM("user_customer_brand");
        if (authorityReq.getUserId() != null) {
            sql.WHERE("userId=#{authorityReq.userId}");
        }
        if (authorityReq.getCustomerId() != null) {
            sql.WHERE("customerId=#{authorityReq.customerId}");
        }
        if (authorityReq.getBrandId() != null) {
            sql.WHERE("brandId=#{brandId}");
        }
        return sql.toString();
    }
}
