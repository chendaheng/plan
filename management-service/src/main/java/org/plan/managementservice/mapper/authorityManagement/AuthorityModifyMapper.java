package org.plan.managementservice.mapper.authorityManagement;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.plan.managementfacade.model.authorityModel.AuthorityReq;

@Mapper
public interface AuthorityModifyMapper {
    @Insert("INSERT INTO user_customer_brand(userId, customerId, brandId) VALUES(authorityReq.userId, authorityReq.customerId, authorityReq.brandId);")
    int addUserDataAuthority(@Param("authorityReq") AuthorityReq authorityReq);

    @Delete("DELETE FROM user_customer_brand WHERE id=#{id};")
    int deleteUserDataAuthority(@Param("id") int id);
}
