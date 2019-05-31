package org.plan.managementweb.authorityManagement;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.plan.managementfacade.model.authorityModel.DataAuthorityReq;
import org.plan.managementfacade.model.authorityModel.SystemAuthorityReq;
import org.plan.managementservice.general.CheckObject;
import org.plan.managementservice.general.ErrorCode;
import org.plan.managementservice.service.authorityManagement.AuthorityModifyServiceImply;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("/authorityManagement")
@Api(value = "权限信息增删接口", tags = {"权限信息增删接口"})
@CrossOrigin(allowCredentials = "true", allowedHeaders = "*",
        methods = {RequestMethod.POST, RequestMethod.DELETE},
        origins = "*")
public class AuthorityModifyController {
    @Autowired
    private AuthorityModifyServiceImply authorityModifyService;

    @PostMapping(value = "/addUserDataAuthority")
    @ApiOperation(value = "增加用户的数据操作权限", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public int addUserDataAuthority (@RequestBody @NotNull DataAuthorityReq dataAuthorityReq) {
        if (CheckObject.isContainsEmpty(dataAuthorityReq) || dataAuthorityReq.getBrandIdList().size() == 0) {
            return ErrorCode.fieldIsEmpty;
        } else {
            return authorityModifyService.addUserDataAuthority(dataAuthorityReq);
        }
    }

    @PostMapping(value = "/addRoleSystemAuthority")
    @ApiOperation(value = "增加角色的系统操作权限", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public int addRoleSystemAuthority (@RequestBody @NotNull SystemAuthorityReq systemAuthorityReq) {
        if (CheckObject.isContainsEmpty(systemAuthorityReq)) {
            return ErrorCode.fieldIsEmpty;
        } else {
            return authorityModifyService.addRoleSystemAuthority(systemAuthorityReq);
        }
    }

    @DeleteMapping(value = "/deleteUserDataAuthority")
    @ApiOperation(value = "删除用户的数据操作权限", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public int deleteUserDataAuthority (@RequestParam("userId") int userId, @RequestParam("brandId") int brandId) {
        return authorityModifyService.deleteUserDataAuthority(userId, brandId);
    }

    @DeleteMapping(value = "/deleteRoleSystemAuthority")
    @ApiOperation(value = "删除角色的系统操作权限", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public int deleteRoleSystemAuthority (@RequestParam("roleId") int roleId, @RequestParam("pageName") String pageName) {
        return authorityModifyService.deleteRoleSystemAuthority(roleId, pageName);
    }
}
