package org.plan.managementweb.authorityManagement;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.plan.managementfacade.model.authorityModel.DataAuthorityResp;
import org.plan.managementfacade.model.authorityModel.SystemAuthority;
import org.plan.managementservice.service.authorityManagement.Imply.AuthorityObtainServiceImply;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Set;

@RestController
@RequestMapping("/authorityManagement")
@Api(value = "权限信息查询接口", tags = {"权限信息查询接口"})
@CrossOrigin(allowCredentials = "true", allowedHeaders = "*",
        methods = {RequestMethod.GET},
        origins = "*")
public class AuthorityObtainController {
    @Autowired
    private AuthorityObtainServiceImply authorityObtainService;

    @GetMapping(value = "/getUserDataAuthority")
    @ApiOperation(value = "获取用户数据权限列表", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<DataAuthorityResp> getUserDataAuthority (@RequestParam Map<String, Object> params) {
        return authorityObtainService.getUserDataAuthorityByParams(params);
    }

    @GetMapping(value = "/getRoleSystemAuthority")
    @ApiOperation(value = "获取角色系统权限列表", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<SystemAuthority> getRoleSystemAuthority (@RequestParam Map<String, Object> params) {
        return authorityObtainService.getRoleSystemAuthorityByParams(params);
    }

    @GetMapping(value = "/getSystemAuthorityByRole")
    @ApiOperation(value = "依据角色获取系统权限", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Set<String> getSystemAuthorityByRole (@RequestParam List<Integer> roleIdList) {
        return authorityObtainService.getSystemAuthorityByRole(roleIdList);
    }
}
