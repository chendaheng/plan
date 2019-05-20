package org.plan.managementservice.service.authorityManagement.Imply;

import org.plan.managementfacade.model.authorityModel.AuthorityReq;
import org.plan.managementfacade.model.authorityModel.AuthorityResp;
import org.plan.managementservice.mapper.authorityManagement.AuthorityObtainMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class AuthorityObtainServiceImply {
    @Autowired
    private AuthorityObtainMapper authorityObtainMapper;

    public List<AuthorityResp> getUserDataAuthorityByParams (Map<String, Object> params) {
        return authorityObtainMapper.getUserDataAuthorityByParams(params);
    }
}
