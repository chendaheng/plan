package org.plan.managementweb.authorityManagement;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.plan.managementfacade.model.authorityModel.AuthorityReq;
import org.plan.managementservice.general.ErrorCode;
import org.plan.managementservice.service.authorityManagement.Imply.AuthorityModifyServiceImply;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("/authorityManagement")
@Api(value = "用户数据权限增删接口", tags = {"用户数据权限增删接口"})
@CrossOrigin(allowCredentials = "true", allowedHeaders = "*",
        methods = {RequestMethod.POST, RequestMethod.DELETE},
        origins = "*")
public class AuthorityModifyController {
    @Autowired
    private AuthorityModifyServiceImply authorityModifyService;

    @PostMapping(value = "/addUserDataAuthority")
    @ApiOperation(value = "增加用户的数据操作权限", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public int addUserDataAuthority (@RequestBody @NotNull AuthorityReq authorityReq) {
        if (authorityReq.getUserId() > 0 && authorityReq.getCustomerId() > 0 && authorityReq.getBrandId() >= 0) {
            return authorityModifyService.addUserDataAuthority(authorityReq);
        } else {
            return ErrorCode.errCodeClassIsEmpty;
        }
    }

    @DeleteMapping(value = "/deleteUserDataAuthority")
    @ApiOperation(value = "删除用户的数据操作权限", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public int deleteUserDataAuthority (@RequestParam("id") int id) {
        return authorityModifyService.deleteUserDataAuthority(id);
    }
}
