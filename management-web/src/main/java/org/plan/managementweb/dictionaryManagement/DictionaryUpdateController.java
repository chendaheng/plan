package org.plan.managementweb.dictionaryManagement;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.plan.managementfacade.model.dictionaryModel.CategoryProperty;
import org.plan.managementfacade.model.dictionaryModel.DictionaryCategory;
import org.plan.managementservice.general.CheckObject;
import org.plan.managementservice.general.ErrorCode;
import org.plan.managementservice.service.dictionaryManagement.DictionaryUpdateServiceImply;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("/dictionaryManagement")
@Api(value = "数据字典信息修改接口", tags = {"数据字典信息修改接口"})
@CrossOrigin(allowCredentials = "true", allowedHeaders = "*",
        methods = {RequestMethod.POST},
        origins = "*")
public class DictionaryUpdateController {
    @Autowired
    private DictionaryUpdateServiceImply dictionaryUpdateService;

    @PostMapping(value = "/updateDictionaryCategory")
    @ApiOperation(value = "更新字典类别", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public int updateDictionaryCategory (@RequestBody @NotNull DictionaryCategory dictionaryCategory) {
        if (CheckObject.isContainsEmpty(dictionaryCategory)) {
            return ErrorCode.fieldIsEmpty;
        }
        return dictionaryUpdateService.updateDictionaryCategory(dictionaryCategory);
    }

    @PostMapping(value = "/updateCategoryProperty")
    @ApiOperation(value = "更新类别属性", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public int updateCategoryProperty (@RequestBody @NotNull CategoryProperty categoryProperty) {
        if (CheckObject.isContainsEmpty(categoryProperty)) {
            return ErrorCode.fieldIsEmpty;
        }
        return dictionaryUpdateService.updateCategoryProperty(categoryProperty);
    }
}
