package org.plan.managementservice.service.authorityManagement.Imply;

import org.plan.managementfacade.model.authorityModel.DataAuthorityResp;
import org.plan.managementfacade.model.authorityModel.SystemAuthority;
import org.plan.managementservice.mapper.authorityManagement.AuthorityObtainMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Component
public class AuthorityObtainServiceImply {
    @Autowired
    private AuthorityObtainMapper authorityObtainMapper;

    public List<DataAuthorityResp> getUserDataAuthorityByParams (Map<String, Object> params) {
        return authorityObtainMapper.getUserDataAuthorityByParams(params);
    }

    public List<SystemAuthority> getRoleSystemAuthorityByParams (Map<String, Object> params) {
        return authorityObtainMapper.getRoleSystemAuthorityByParams(params);
    }

    public Set<String> getSystemAuthorityByRole (List<Integer> roleIdList) {
        Set<String> result = new HashSet<>();
        for (Integer roleId : roleIdList) {
            List<String> pageNameList = authorityObtainMapper.getSystemAuthorityByRoleId(roleId);
            result.addAll(pageNameList);
        }
        return result;
    }
}
