package org.plan.managementweb.baseInfoManagement;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.plan.managementfacade.model.baseInfoModel.responseModel.BrandName;
import org.plan.managementfacade.model.baseInfoModel.responseModel.BrandResp;
import org.plan.managementfacade.model.baseInfoModel.responseModel.ClothingLevelName;
import org.plan.managementfacade.model.baseInfoModel.responseModel.CustomerName;
import org.plan.managementfacade.model.baseInfoModel.sqlModel.ClothingLevel;
import org.plan.managementfacade.model.baseInfoModel.sqlModel.Customer;
import org.plan.managementfacade.model.baseInfoModel.sqlModel.Product;
import org.plan.managementservice.service.baseInfoManagement.Imply.BaseInfoObtainServiceImply;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/baseInfoManagement")
@Api(value = "基本信息获取接口", tags = {"基本信息获取接口"})
@CrossOrigin(allowCredentials = "true", allowedHeaders = "*",
        methods = {RequestMethod.GET},
        origins = "*")
public class BaseInfoObtainController {

    private final static Logger logger = LoggerFactory.getLogger("zhuriLogger");

    @Autowired
    private BaseInfoObtainServiceImply baseInfoObtainService;

    @GetMapping(value = "/getProduct")
    @ApiOperation(value = "获取产品信息列表", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Product> getProduct (@RequestParam(value = "name", required = false) String name) {
        return baseInfoObtainService.getProduct(name);
    }

    @GetMapping(value = "/getCustomer")
    @ApiOperation(value = "获取客户信息列表", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Customer> getCustomer (@RequestParam(value = "name", required = false) String name) {
        return baseInfoObtainService.getCustomer(name);
    }

    @GetMapping (value = "/getCustomerName")
    @ApiOperation(value = "获取客户名称", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List <CustomerName> getCustomerName () {
        int userId = 3;
        return baseInfoObtainService.getCustomerName(userId);
    }

    @GetMapping(value = "/getBrand")
    @ApiOperation(value = "获取品牌信息列表", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<BrandResp> getBrand (@RequestParam(value = "name", required = false) String name) {
        return baseInfoObtainService.getBrand(name);
    }

    @GetMapping (value = "/getBrandName")
    @ApiOperation(value = "获取品牌名称", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List <BrandName> getBrandName(@RequestParam(value = "id", required = false) Integer customerId ){
        return baseInfoObtainService.getBrandName(customerId);
    }

    @GetMapping(value = "/getClothingLevel")
    @ApiOperation(value = "获取服装层次信息列表", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<ClothingLevel> getClothingLevel (@RequestParam(value = "name", required = false) String name) {
        return baseInfoObtainService.getClothingLevel(name);
    }

    @GetMapping (value = "/getClothingLevelName")
    @ApiOperation(value = "获取服装层次名称", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List <ClothingLevelName> getClothingLevelName(){
        return baseInfoObtainService.getClothingLevelName();
    }
}
