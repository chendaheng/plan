package org.plan.managementweb.infoManagement;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.plan.managementfacade.model.infoModel.requestModel.*;
import org.plan.managementservice.general.ErrorCode;
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

    @RequestMapping (value = "/addRangeList", method = RequestMethod.POST)
    @ApiOperation(value = "批量新增系列")
    public int addRangeList(@RequestBody List <RangeAddRequest> rangeAddRequestList){
        int listSize = rangeAddRequestList.size();
        int addSize = infoModifyServiceImply.addRangeList(rangeAddRequestList);
        if (listSize != addSize){
            logger.warn("传入列表的长度为" + listSize + ",实际增加的长度为" + addSize + ",请检查前端传入的数据");
        }
        return addSize;
    }

    @RequestMapping (value = "/deleteRange", method = RequestMethod.POST)
    @ApiOperation(value = "删除单条系列")
    public int deleteRange(@RequestParam int id){
        try {
            return infoModifyServiceImply.deleteRange(id);
        }
        catch (Exception e){
            logger.error("删除操作出错，错误为" + e);
            return ErrorCode.sqlError;
        }
    }
}
