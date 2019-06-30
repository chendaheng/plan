package org.plan.managementweb.baseInfoManagement;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.plan.managementfacade.model.baseInfoModel.sqlModel.*;
import org.plan.managementservice.general.CheckObject;
import org.plan.managementservice.general.ErrorCode;
import org.plan.managementservice.service.baseInfoManagement.BaseInfoUpdateServiceImply;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("/baseInfoManagement")
@Api(value = "基本信息修改接口", tags = {"基本信息修改接口"})
@CrossOrigin(allowCredentials = "true", allowedHeaders = "*",
        methods = {RequestMethod.POST, RequestMethod.GET},
        origins = "*")
public class BaseInfoUpdateController {
    @Autowired
    private BaseInfoUpdateServiceImply baseInfoUpdateService;

    @PostMapping(value = "/updateProduct")
    @ApiOperation(value = "更新产品信息", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public int updateProduct (@RequestBody @NotNull Product product) {
        if (CheckObject.isContainsEmpty(product)) {
            return ErrorCode.fieldIsEmpty;
        } else {
            return baseInfoUpdateService.updateProduct(product);
        }
    }

    @PostMapping(value = "/updateCustomer")
    @ApiOperation(value = "更新客户信息", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public int updateCustomer (@RequestBody @NotNull Customer customer) {
        if (CheckObject.isContainsEmpty(customer)) {
            return ErrorCode.fieldIsEmpty;
        } else {
            return baseInfoUpdateService.updateCustomer(customer);
        }
    }

    @PostMapping(value = "/updateBrand")
    @ApiOperation(value = "更新品牌信息", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public int updateBrand (@RequestBody @NotNull Brand brand) {
        if (CheckObject.isContainsEmpty(brand)) {
            return ErrorCode.fieldIsEmpty;
        } else {
            return baseInfoUpdateService.updateBrand(brand);
        }
    }

    @PostMapping(value = "/updateClothingLevel")
    @ApiOperation(value = "更新服装层次信息", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public int updateClothingLevel (@RequestBody @NotNull ClothingLevel clothingLevel) {
        if (CheckObject.isContainsEmpty(clothingLevel)) {
            return ErrorCode.fieldIsEmpty;
        } else {
            return baseInfoUpdateService.updateClothingLevel(clothingLevel);
        }
    }

    @PostMapping(value = "/updateSerialNoRegular")
    @ApiOperation(value = "更新单号规则", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public int updateSerialNoRegular(@RequestBody @NotNull SerialNoRegular serialNoRegular){
        return baseInfoUpdateService.updateSerialNoRegular(serialNoRegular);
    }

    @GetMapping(value = "/updateMessageStateRead")
    @ApiOperation(value = "将消息状态更新为已读", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public int updateMessageStateRead(@RequestParam("id") int id){
        return baseInfoUpdateService.updateMessageStateRead(id);
    }
}
