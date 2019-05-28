package org.plan.managementservice.mapper.authorityManagement;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.plan.managementfacade.model.authorityModel.DataAuthorityResp;
import org.plan.managementfacade.model.authorityModel.SystemAuthority;

import java.util.List;
import java.util.Map;

@Mapper
public interface AuthorityObtainMapper {
    @SelectProvider(type = AuthorityObtainProvider.class, method = "getUserDataAuthorityByParams")
    List<DataAuthorityResp> getUserDataAuthorityByParams (Map<String, Object> params);

    @SelectProvider(type = AuthorityObtainProvider.class, method = "getRoleSystemAuthorityByParams")
    List<SystemAuthority> getRoleSystemAuthorityByParams (Map<String, Object> params);

    @Select("SELECT * FROM `role_page` WHERE roleId=#{roleId}")
    List<String> getSystemAuthorityByRoleId (@Param("roleId") Integer roleId);
}
