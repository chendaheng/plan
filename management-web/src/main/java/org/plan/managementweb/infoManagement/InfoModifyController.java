package org.plan.managementweb.infoManagement;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.plan.managementfacade.model.infoModel.requestModel.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/infoManagement")
@Api(value = "增删信息")
@CrossOrigin(allowCredentials = "true", allowedHeaders = "*",
        origins = "*")
public class InfoModifyController {

    @RequestMapping (value = "/addRange", method = RequestMethod.POST)
    @ApiOperation(value = "新增单条系列")
    public int addRange(@RequestBody RangeAddRequest rangeAddRequest){
        return 0;
    }
}
