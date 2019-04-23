package org.plan.managementweb.infoManagement;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.plan.managementfacade.model.infoModel.requestModel.*;
import org.plan.managementservice.service.infoManagement.Imply.InfoModifyServiceImply;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/infoManagement")
@Api(value = "增删信息")
@CrossOrigin(allowCredentials = "true", allowedHeaders = "*",
        origins = "*")
public class InfoModifyController {

    private final static Logger logger = LoggerFactory.getLogger("zhuriLogger");

    @Autowired
    private InfoModifyServiceImply infoModifyServiceImply;

    @RequestMapping (value = "/addRange", method = RequestMethod.POST)
    @ApiOperation(value = "新增单条系列")
    public int addRange(@RequestBody RangeAddRequest rangeAddRequest){
        return infoModifyServiceImply.addRange(rangeAddRequest);
    }
}
