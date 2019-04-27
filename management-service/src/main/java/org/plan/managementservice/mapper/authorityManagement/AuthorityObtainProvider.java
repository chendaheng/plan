package org.plan.managementservice.mapper.authorityManagement;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.jdbc.SQL;
import org.plan.managementfacade.model.authorityModel.AuthorityReq;

public class AuthorityObtainProvider {
    public String getUserDataAuthorityByParams (@Param("authorityReq") AuthorityReq authorityReq) {
        SQL sql = new SQL();
        sql.SELECT("user_customer_brand.*, customer.name AS customerName, brand.name AS brandName");
        sql.FROM("user_customer_brand").LEFT_OUTER_JOIN("customer ON user_customer_brand.customerId=customer.id")
                .LEFT_OUTER_JOIN("brand ON user_customer_brand.brandId=brand.id");
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
