package org.plan.managementservice.mapper.authorityManagement;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.plan.managementfacade.model.authorityModel.AuthorityReq;
import org.plan.managementfacade.model.authorityModel.UserAuthority;

import java.util.List;

@Mapper
public interface AuthorityObtainMapper {
    @Select("SELECT COUNT(*) FROM user_customer_brand WHERE userId=#{userId} AND brandId=#{brandId};")
    int getUserAuthorityCountByUserIdAndBrandId (@Param("userId") int userId, @Param("brandId") int brandId);

    @SelectProvider(type = AuthorityObtainProvider.class, method = "getUserDataAuthorityByParams")
    List<UserAuthority> getUserDataAuthorityByParams (@Param("authorityReq")AuthorityReq authorityReq);
}
