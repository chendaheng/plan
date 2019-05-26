package org.plan.managementservice.mapper.authorityManagement;

import org.apache.ibatis.annotations.*;

@Mapper
public interface AuthorityModifyMapper {
    @Insert("INSERT INTO `user_customer_brand` VALUES(#{userId}, #{userName}, #{customerId}, #{brandId});")
    int addUserDataAuthority(@Param("userId") Integer userId, @Param("userName") String userName, @Param("customerId") Integer customerId, @Param("brandId") Integer brandId);

    @Delete("DELETE FROM `user_customer_brand` WHERE id=#{id};")
    int deleteUserDataAuthority(@Param("id") int id);
}
