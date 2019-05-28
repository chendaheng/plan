package org.plan.managementservice.mapper.authorityManagement;

import org.apache.ibatis.annotations.*;

@Mapper
public interface AuthorityModifyMapper {
    @Insert("INSERT INTO `user_customer_brand` VALUES(#{userId}, #{userName}, #{customerId}, #{brandId});")
    int addUserDataAuthority(@Param("userId") Integer userId, @Param("userName") String userName, @Param("customerId") Integer customerId, @Param("brandId") Integer brandId);

    @Insert("INSERT INTO `role_page` VALUES(#{roleId}, #{roleName}, #{pageName});")
    int addRoleSystemAuthority(@Param("roleId") Integer roleId, @Param("roleName") String roleName, @Param("pageName") String pageName);

    @Delete("DELETE FROM `user_customer_brand` WHERE userId=#{userId} AND brandId=#{brandId};")
    int deleteUserDataAuthority(@Param("userId") int userId, @Param("brandId") int brandId);

    @Delete("DELETE FROM `role_page` WHERE roleId=#{roleId} AND pageName=#{pageName};")
    int deleteRoleSystemAuthority(@Param("roleId") int roleId, @Param("pageName") String pageName);
}
