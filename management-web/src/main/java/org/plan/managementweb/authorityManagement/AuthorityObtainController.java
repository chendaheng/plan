package org.plan.managementweb.authorityManagement;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.plan.managementfacade.model.authorityModel.AuthorityReq;
import org.plan.managementfacade.model.authorityModel.AuthorityResp;
import org.plan.managementservice.service.authorityManagement.Imply.AuthorityObtainServiceImply;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("/authorityManagement")
@Api(value = "用户数据权限信息查询接口", tags = {"用户数据权限信息查询接口"})
@CrossOrigin(allowCredentials = "true", allowedHeaders = "*",
        methods = {RequestMethod.GET},
        origins = "*")
public class AuthorityObtainController {
    @Autowired
    private AuthorityObtainServiceImply authorityObtainService;

    @GetMapping(value = "/getUserDataAuthority")
    @ApiOperation(value = "获取全部数据字典类别", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<AuthorityResp> getUserDataAuthorityByParams (@RequestBody @NotNull AuthorityReq authorityReq) {
        return authorityObtainService.getUserDataAuthorityByParams(authorityReq);
    }

}
