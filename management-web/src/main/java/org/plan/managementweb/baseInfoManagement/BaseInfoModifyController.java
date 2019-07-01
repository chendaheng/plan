package org.plan.managementweb.baseInfoManagement;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.plan.managementfacade.model.baseInfoModel.requestModel.*;
import org.plan.managementservice.general.CheckObject;
import org.plan.managementservice.general.ErrorCode;
import org.plan.managementservice.general.GatewayInfo;
import org.plan.managementservice.service.baseInfoManagement.BaseInfoModifyServiceImply;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("/baseInfoManagement")
@Api(value = "基本信息增删接口", tags = {"基本信息增删接口"})
@CrossOrigin(allowCredentials = "true", allowedHeaders = "*",
        methods = {RequestMethod.POST, RequestMethod.DELETE},
        origins = "*")
public class BaseInfoModifyController {
    @Autowired
    private BaseInfoModifyServiceImply baseInfoModifyService;

    @PostMapping(value = "/addProduct")
    @ApiOperation(value = "增加产品信息", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public int addProduct (@RequestBody @NotNull ProductReq productReq) {
        if(CheckObject.isContainsEmpty(productReq)) {
            return ErrorCode.fieldIsEmpty;
        } else {
            return baseInfoModifyService.addProduct(productReq);
        }
    }

    @PostMapping(value = "/addCustomer")
    @ApiOperation(value = "增加客户信息", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public int addCustomer (@RequestBody @NotNull CustomerReq customerReq) {
        if (CheckObject.isContainsEmpty(customerReq)) {
            return ErrorCode.fieldIsEmpty;
        } else {
            return baseInfoModifyService.addCustomer(customerReq);
        }
    }

    @PostMapping(value = "/addBrand")
    @ApiOperation(value = "增加品牌信息", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public int addBrand (@RequestBody @NotNull BrandReq brandReq) {
        if (CheckObject.isContainsEmpty(brandReq)) {
            return ErrorCode.fieldIsEmpty;
        } else {
            return baseInfoModifyService.addBrand(brandReq);
        }
    }

    @PostMapping(value = "/addClothingLevel")
    @ApiOperation(value = "增加服装层次信息", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public int addClothingLevel (@RequestBody @NotNull ClothingLevelReq clothingLevelReq) {
        if (CheckObject.isContainsEmpty(clothingLevelReq)) {
            return ErrorCode.fieldIsEmpty;
        } else {
            return baseInfoModifyService.addClothingLevel(clothingLevelReq);
        }
    }

    @DeleteMapping(value = "/deleteProduct")
    @ApiOperation(value = "删除产品信息", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public int deleteProduct (@RequestParam("id") int id) {
        return baseInfoModifyService.deleteProduct(id);
    }

    @DeleteMapping(value = "/deleteCustomer")
    @ApiOperation(value = "删除产品信息", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public int deleteCustomer (@RequestParam("id") int id) {
        return baseInfoModifyService.deleteCustomer(id);
    }

    @DeleteMapping(value = "/deleteBrand")
    @ApiOperation(value = "删除产品信息", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public int deleteBrand (@RequestParam("id") int id) {
        return baseInfoModifyService.deleteBrand(id);
    }

    @DeleteMapping(value = "/deleteClothingLevel")
    @ApiOperation(value = "删除产品信息", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public int deleteClothingLevel (@RequestParam("id") int id) {
        return baseInfoModifyService.deleteClothingLevel(id);
    }

    @PostMapping(value = "/addMessage")
    @ApiOperation(value = "增加消息", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public int addMessage(@RequestBody @NotNull MessageAddReq messageAddReq){
        int senderId = GatewayInfo.getUserId();
        String senderName = GatewayInfo.getUserName();
        messageAddReq.setSenderId(senderId);
        messageAddReq.setSenderName(senderName);
        return baseInfoModifyService.addMessage(messageAddReq);
    }
}
