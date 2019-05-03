package org.plan.managementservice.mapper.authorityManagement;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.jdbc.SQL;
import org.plan.managementfacade.model.authorityModel.AuthorityReq;

public class AuthorityObtainProvider {
    public String getUserDataAuthorityByParams (@Param("authorityReq") AuthorityReq authorityReq) {
        return new SQL() {
            {
                SELECT("user_customer_brand.*, customer.name AS customerName, brand.name AS brandName");
                FROM("user_customer_brand").LEFT_OUTER_JOIN("customer ON user_customer_brand.customerId=customer.id")
                        .LEFT_OUTER_JOIN("brand ON user_customer_brand.brandId=brand.id");
                if (authorityReq.getUserId() != null) {
                    WHERE("userId=#{authorityReq.userId}");
                }
                if (authorityReq.getCustomerId() != null) {
                    WHERE("customerId=#{authorityReq.customerId}");
                }
                if (authorityReq.getBrandId() != null) {
                    WHERE("brandId=#{brandId}");
                }
            }
        }.toString();
    }
}
