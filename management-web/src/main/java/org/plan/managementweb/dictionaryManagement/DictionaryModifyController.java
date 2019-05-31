package org.plan.managementweb.dictionaryManagement;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.plan.managementfacade.model.dictionaryModel.CategoryReq;
import org.plan.managementfacade.model.dictionaryModel.PropertyReq;
import org.plan.managementservice.general.CheckObject;
import org.plan.managementservice.general.ErrorCode;
import org.plan.managementservice.service.dictionaryManagement.DictionaryModifyServiceImply;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("/dictionaryManagement")
@Api(value = "数据字典信息增删接口", tags = {"数据字典信息增删接口"})
@CrossOrigin(allowCredentials = "true", allowedHeaders = "*",
             methods = {RequestMethod.POST, RequestMethod.DELETE},
             origins = "*")
public class DictionaryModifyController {
    @Autowired
    private DictionaryModifyServiceImply dictionaryModifyService;

    @PostMapping(value = "/addDictionaryCategory")
    @ApiOperation(value = "增加字典类别", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public int addDictionaryCategory (@RequestBody @NotNull CategoryReq categoryReq) {
        if (CheckObject.isContainsEmpty(categoryReq)) {
            return ErrorCode.fieldIsEmpty;
        }
        return dictionaryModifyService.addCategory(categoryReq);
    }

    @PostMapping(value = "/addCategoryProperty")
    @ApiOperation(value = "增加类别属性", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public int addCategoryProperty (@RequestBody PropertyReq propertyReq) {
        if (CheckObject.isContainsEmpty(propertyReq)) {
            return ErrorCode.fieldIsEmpty;
        }
        return dictionaryModifyService.addProperty(propertyReq);
    }

    @DeleteMapping(value = "/deleteDictionaryCategory")
    @ApiOperation(value = "删除字典类别", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public int deleteDictionaryCategory (@RequestParam("id") int id) {
        return dictionaryModifyService.deleteCategoryById(id);
    }

    @DeleteMapping(value = "/deleteCategoryProperty")
    @ApiOperation(value = "删除类别属性", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public int deleteCategoryProperty (@RequestParam("id") int id) {
        return dictionaryModifyService.deletePropertyById(id);
    }
}
