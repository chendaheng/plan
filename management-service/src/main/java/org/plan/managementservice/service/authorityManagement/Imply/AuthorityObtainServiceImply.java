package org.plan.managementservice.service.authorityManagement.Imply;

import org.plan.managementfacade.model.authorityModel.AuthorityReq;
import org.plan.managementfacade.model.authorityModel.UserAuthority;
import org.plan.managementservice.mapper.authorityManagement.AuthorityObtainMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AuthorityObtainServiceImply {
    @Autowired
    private AuthorityObtainMapper authorityObtainMapper;

    public List<UserAuthority> getUserDataAuthorityByParams (AuthorityReq authorityReq) {
        return authorityObtainMapper.getUserDataAuthorityByParams(authorityReq);
    }
}
