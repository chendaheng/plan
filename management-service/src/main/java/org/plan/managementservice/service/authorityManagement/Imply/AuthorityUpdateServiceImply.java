package org.plan.managementservice.service.authorityManagement.Imply;

import org.plan.managementfacade.model.authorityModel.UserAuthority;
import org.plan.managementservice.general.ErrorCode;
import org.plan.managementservice.mapper.authorityManagement.AuthorityObtainMapper;
import org.plan.managementservice.mapper.authorityManagement.AuthorityUpdateMapper;
import org.plan.managementservice.mapper.baseInfoManagement.BaseInfoObtainMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AuthorityUpdateServiceImply {
    @Autowired
    private AuthorityUpdateMapper authorityUpdateMapper;
    @Autowired
    private AuthorityObtainMapper authorityObtainMapper;
    @Autowired
    private BaseInfoObtainMapper baseInfoObtainMapper;

    public int updateUserDataAuthorityById (UserAuthority userAuthority) {
        int id = userAuthority.getId();
        int customerId = userAuthority.getCustomerId();
        int brandId = userAuthority.getBrandId();
        // 用户对品牌的操作权限必须在客户权限之下
        if (customerId != baseInfoObtainMapper.getCustomerIdByBrandId(brandId)) {
            return ErrorCode.dataInconsistency;
        }
        List<UserAuthority> userAuthorityList = authorityObtainMapper.getUserAuthorityCountByUserIdAndBrandId(userAuthority.getUserId(), userAuthority.getBrandId());
        int result;
        switch (userAuthorityList.size()) {
            case 0:
                result = authorityUpdateMapper.updateUserDataAuthorityById(userAuthority);
                break;
            case 1:
                if(id == userAuthorityList.get(0).getId()) {
                    result = authorityUpdateMapper.updateUserDataAuthorityById(userAuthority);
                } else {
                    result = ErrorCode.paramDuplication;
                }
                break;
            default:
                result = ErrorCode.databaseError;
        }
        return result;
    }
}
