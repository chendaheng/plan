package org.plan.managementservice.mapper.authorityManagement;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.jdbc.SQL;
import org.plan.managementfacade.model.authorityModel.AuthorityReq;

import java.util.Map;

public class AuthorityObtainProvider {
    public String getUserDataAuthorityByParams (Map<String, Object> params) {
        String[] keyList = {"userId", "customerId", "brandId"};
        return new SQL() {
            {
                SELECT("user_customer_brand.*, customer.name AS customerName, brand.name AS brandName");
                FROM("user_customer_brand").LEFT_OUTER_JOIN("customer ON user_customer_brand.customerId=customer.id")
                        .LEFT_OUTER_JOIN("brand ON user_customer_brand.brandId=brand.id");
                for (String key : keyList) {
                    if (params.containsKey(key)) {
                        Object value = params.get(key);
                        WHERE(key + "='" + value + "'");
                    }
                }
            }
        }.toString();
    }
}
