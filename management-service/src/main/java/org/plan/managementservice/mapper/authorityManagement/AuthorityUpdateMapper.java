package org.plan.managementservice.mapper.authorityManagement;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import org.plan.managementfacade.model.authorityModel.UserAuthority;

@Mapper
public interface AuthorityUpdateMapper {
    @Update("UPDATE user_customer_brand SET userId=#{userAuthority.userId}, customerId=#{userAuthority.customerId}, brandId=#{brandId} WHERE id=#{userAuthority.id};")
    int updateUserDataAuthorityById (@Param("userAuthority") UserAuthority userAuthority);
}
