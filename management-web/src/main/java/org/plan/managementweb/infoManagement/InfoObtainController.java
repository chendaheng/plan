package org.plan.managementweb.infoManagement;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.auth.In;
import org.plan.managementfacade.model.infoModel.requestModel.*;
import org.plan.managementfacade.model.infoModel.responseModel.*;
import org.plan.managementservice.general.GatewayInfo;
import org.plan.managementservice.service.infoManagement.Imply.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/infoManagement")
@Api(value = "获取信息")
@CrossOrigin(allowCredentials = "true", allowedHeaders = "*",
        origins = "*")
public class InfoObtainController {

    @Autowired
    private InfoObtainServiceImply infoObtainServiceImply;

    @RequestMapping (value = "/getRangeName", method = RequestMethod.GET)
    @ApiOperation(value = "获取系列名称")
    public List <RangeName> getRangeName(@RequestParam(value = "brandId", required = false) Integer brandId){
        int userId = GatewayInfo.getUserId();
        return infoObtainServiceImply.getRangeName(userId, brandId);
    }

    @RequestMapping (value = "/getRangeList", method = RequestMethod.POST)
    @ApiOperation(value = "获取系列response信息")
    public List <RangeResponse> getRangeList(@RequestBody RangeSearchRequest rangeSearchRequest){
        int userId = GatewayInfo.getUserId();
        rangeSearchRequest.setUserId(userId);
        return infoObtainServiceImply.getRangeResponse(rangeSearchRequest);
    }

    @RequestMapping (value = "/getStyleGroupName", method = RequestMethod.GET)
    @ApiOperation(value = "获取款式组名称")
    public List <StyleGroupName> getStyleGroupName(@RequestParam(value = "rangeId", required = false) Integer rangeId){
        return infoObtainServiceImply.getStyleGroupName(rangeId);
    }

    @RequestMapping (value = "/getStyleGroupList", method = RequestMethod.POST)
    @ApiOperation(value = "获取款式组response信息")
    public List <StyleGroupResponse> getStyleGroupList(@RequestBody StyleGroupSearchRequest styleGroupSearchRequest){
        int userId = GatewayInfo.getUserId();
        styleGroupSearchRequest.setUserId(userId);
        return infoObtainServiceImply.getStyleGroupResponse(styleGroupSearchRequest);
    }

    @RequestMapping (value = "/getStyleNumber", method = RequestMethod.GET)
    @ApiOperation(value = "获取订单款号")
    public List <StyleNumber> getStyleNumber(@RequestParam(value = "rangeId", required = false) Integer rangeId){
        return infoObtainServiceImply.getStyleNumber(rangeId);
    }

    @RequestMapping (value = "/getStyleList", method = RequestMethod.POST)
    @ApiOperation(value = "获取款式response信息")
    public List <StyleResponse> getStyleList(@RequestBody StyleSearchRequest styleSearchRequest){
        int userId = GatewayInfo.getUserId();
        styleSearchRequest.setUserId(userId);
        return infoObtainServiceImply.getStyleResponse(styleSearchRequest);
    }
}
