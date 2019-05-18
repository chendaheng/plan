package org.plan.managementweb.infoManagement;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.plan.managementfacade.model.infoModel.requestModel.*;
import org.plan.managementservice.service.infoManagement.Imply.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @RequestMapping (value = "/bindStyleGroup", method = RequestMethod.POST)
    @ApiOperation(value = "绑定款式组")
    public int bindStyleGroup(@RequestBody List <BindStyleGroupRequest> bindStyleGroupRequestList){
        int listSize = bindStyleGroupRequestList.size();
        int updateSize = infoUpdateServiceImply.bindStyleGroup(bindStyleGroupRequestList);
        if (listSize != updateSize){
            logger.warn("传入列表的长度为" + listSize + ",实际更新的长度为" + updateSize + ",请检查前端传入的数据");
        }
        return updateSize;
    }

    @RequestMapping (value = "/unbindStyleGroup", method = RequestMethod.GET)
    @ApiOperation(value = "解绑款式组")
    public int unbindStyleGroup (@RequestParam int id){
        return infoUpdateServiceImply.unbindStyleGroup(id);
    }

    @RequestMapping (value = "/completeRange", method = RequestMethod.GET)
    @ApiOperation(value = "完成系列")
    public int completeRangeById (@RequestParam("id") int id) {
        return infoUpdateServiceImply.completeRangeById(id);
    }
}
