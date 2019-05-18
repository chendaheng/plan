package org.plan.managementweb.dictionaryManagement;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.plan.managementfacade.model.dictionaryModel.CategoryProperty;
import org.plan.managementfacade.model.dictionaryModel.DictionaryCategory;
import org.plan.managementservice.service.dictionaryManagement.Imply.DictionaryObtainServiceImply;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dictionaryManagement")
@Api(value = "数据字典信息获取接口", tags = {"数据字典信息获取接口"})
@CrossOrigin(allowCredentials = "true", allowedHeaders = "*",
             methods = {RequestMethod.GET},
             origins = "*")
public class DictionaryObtainController {
    @Autowired
    private DictionaryObtainServiceImply dictionaryObtainService;

    @GetMapping(value = "/getAllDictionaryCategory")
    @ApiOperation(value = "获取全部数据字典类别", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<DictionaryCategory> getAllDictionaryCategory () {
        return dictionaryObtainService.getAllDictionaryCategory();
    }

    @GetMapping(value = "/getDictionaryCategoryIdByName")
    @ApiOperation(value = "依据字典类别名称获取字典类别id", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public int getDictionaryCategoryIdByName (@RequestParam("name") String name) {
        return dictionaryObtainService.getDictionaryCategoryIdByName(name);
    }

    @GetMapping(value = "/getCategoryProperty")
    @ApiOperation(value = "根据类别获取属性", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<CategoryProperty> getCategoryPropertyByCategoryId (@RequestParam("categoryId") int categoryId) {
        return dictionaryObtainService.getCategoryPropertyByCategory(categoryId);
    }
}
