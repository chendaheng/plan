package org.plan.managementservice.mapper.authorityManagement;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.plan.managementfacade.model.authorityModel.AuthorityReq;
import org.plan.managementfacade.model.authorityModel.AuthorityResp;
import org.plan.managementfacade.model.authorityModel.UserAuthority;

import java.util.List;

@Mapper
public interface AuthorityObtainMapper {
    @Select("SELECT * FROM user_customer_brand WHERE userId=#{userId} AND brandId=#{brandId};")
    List<UserAuthority> getUserAuthorityCountByUserIdAndBrandId (@Param("userId") int userId, @Param("brandId") int brandId);

    @SelectProvider(type = AuthorityObtainProvider.class, method = "getUserDataAuthorityByParams")
    List<AuthorityResp> getUserDataAuthorityByParams (@Param("authorityReq")AuthorityReq authorityReq);
}
