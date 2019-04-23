package org.plan.managementweb.infoManagement;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.plan.managementfacade.model.infoModel.requestModel.*;
import org.plan.managementfacade.model.infoModel.responseModel.*;
import org.plan.managementservice.service.infoManagement.Imply.InfoObtainServiceImply;
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
    public List <RangeName> getRangeName(){
        return infoObtainServiceImply.getRangeName();
    }

    @RequestMapping (value = "/getRangeResponse", method = RequestMethod.POST)
    @ApiOperation(value = "获取系列response信息")
    public List <RangeResponse> getRangeResponse(@RequestBody RangeSearchRequest rangeSearchRequest){
        return infoObtainServiceImply.getRangeResponse(rangeSearchRequest);
    }

    @RequestMapping (value = "/getStyleGroupName", method = RequestMethod.GET)
    @ApiOperation(value = "获取款式组名称")
    public List <StyleGroupName> getStyleGroupName(@RequestParam int rangeId){
        return infoObtainServiceImply.getStyleGroupName(rangeId);
    }
}
