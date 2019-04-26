package org.plan.managementweb.authorityManagement;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.plan.managementfacade.model.authorityModel.UserAuthority;
import org.plan.managementservice.general.CheckObject;
import org.plan.managementservice.general.ErrorCode;
import org.plan.managementservice.service.authorityManagement.Imply.AuthorityUpdateServiceImply;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("/authorityManagement")
@Api(value = "用户数据权限更新接口", tags = {"用户数据权限更新接口"})
@CrossOrigin(allowCredentials = "true", allowedHeaders = "*",
        methods = {RequestMethod.POST},
        origins = "*")
public class AuthorityUpdateController {
    @Autowired
    private AuthorityUpdateServiceImply authorityUpdateService;

    @PostMapping(value = "/updateUserDataAuthority")
    @ApiOperation(value = "更新字典类别", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public int updateUserDataAuthorityById (@RequestBody @NotNull UserAuthority userAuthority) {
        if (CheckObject.isContainsEmpty(userAuthority)) {
            return ErrorCode.errCodeClassIsEmpty;
        }
        return authorityUpdateService.updateUserDataAuthorityById(userAuthority);
    }
}
