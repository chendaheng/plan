package org.plan.managementweb.infoManagement;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.plan.managementfacade.model.infoModel.responseModel.*;
import org.plan.managementservice.service.infoManagement.Imply.InfoObtainServiceImply;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/infoObtainManagement")
@Api(value = "获取信息")
@CrossOrigin(allowCredentials = "true", allowedHeaders = "*",
        origins = "*")
public class InfoModifyController {

    @Autowired
    private InfoObtainServiceImply infoObtainServiceImply;

    @RequestMapping (value = "/getRangeName", method = RequestMethod.GET)
    @ApiOperation(value = "获取系列名称")
    public List <RangeName> getRangeName(){
        return infoObtainServiceImply.getRangeName();
    }

    @RequestMapping (value = "/getRangeResponse", method = RequestMethod.GET)
    @ApiOperation(value = "获取系列response信息")
    public List <RangeResponse> getRangeResponse(){
        return infoObtainServiceImply.getRangeResponse();
    }
}
