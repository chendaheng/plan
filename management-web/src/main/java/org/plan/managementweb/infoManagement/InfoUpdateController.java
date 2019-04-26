package org.plan.managementweb.infoManagement;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.plan.managementfacade.model.infoModel.requestModel.*;
import org.plan.managementservice.service.infoManagement.Imply.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/infoManagement")
@Api(value = "更新信息")
@CrossOrigin(allowCredentials = "true", allowedHeaders = "*",
        origins = "*")
public class InfoUpdateController {

    private final static Logger logger = LoggerFactory.getLogger("zhuriLogger");

    @Autowired
    private InfoUpdateServiceImply infoUpdateServiceImply;

    @RequestMapping (value = "/updateRange", method = RequestMethod.POST)
    @ApiOperation(value = "更新系列")
    public int updateRange(@RequestBody RangeUpdateRequest rangeUpdateRequest){
        return infoUpdateServiceImply.updateRange(rangeUpdateRequest);
    }

    @RequestMapping (value = "/updateStyleGroup", method = RequestMethod.POST)
    @ApiOperation(value = "更新款式组")
    public int updateStyleGroup(@RequestBody StyleGroupUpdateRequest styleGroupUpdateRequest){
        return infoUpdateServiceImply.updateStyleGroup(styleGroupUpdateRequest);
    }

    @RequestMapping (value = "/updateStyle", method = RequestMethod.POST)
    @ApiOperation(value = "更新款式")
    public int updateStyle(@RequestBody StyleUpdateRequest styleUpdateRequest){
        return infoUpdateServiceImply.updateStyle(styleUpdateRequest);
    }

}
