package org.plan.managementservice.service.authorityManagement.Imply;

import org.plan.managementfacade.model.authorityModel.UserAuthority;
import org.plan.managementservice.general.ErrorCode;
import org.plan.managementservice.mapper.authorityManagement.AuthorityObtainMapper;
import org.plan.managementservice.mapper.authorityManagement.AuthorityUpdateMapper;
import org.plan.managementservice.mapper.baseInfoManagement.BaseInfoObtainMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AuthorityUpdateServiceImply {
    @Autowired
    private AuthorityUpdateMapper authorityUpdateMapper;
    @Autowired
    private AuthorityObtainMapper authorityObtainMapper;
    @Autowired
    private BaseInfoObtainMapper baseInfoObtainMapper;

    public int updateUserDataAuthorityById (UserAuthority userAuthority) {
        int customerId = userAuthority.getCustomerId();
        int brandId = userAuthority.getBrandId();
        // 用户对品牌的操作权限必须在客户权限之下
        if (customerId != baseInfoObtainMapper.getCustomerIdByBrandId(brandId)) {
            return ErrorCode.dataInconsistency;
        }
        int count = authorityObtainMapper.getUserAuthorityCountByUserIdAndBrandId(userAuthority.getUserId(), userAuthority.getBrandId());
        if (count > 0) {
            //同userId和brandId的记录已存在，不再重复添加数据
            return ErrorCode.paramDuplication;
        } else {
            return authorityUpdateMapper.updateUserDataAuthorityById(userAuthority);
        }
    }

}
