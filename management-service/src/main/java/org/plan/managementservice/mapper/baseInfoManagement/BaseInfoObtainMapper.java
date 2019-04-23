package org.plan.managementservice.mapper.baseInfoManagement;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.plan.managementfacade.model.baseInfoModel.responseModel.*;
import org.plan.managementfacade.model.baseInfoModel.sqlModel.*;

import java.util.List;

@Mapper
public interface BaseInfoObtainMapper {

    // 获取客户名称
    @Select("SELECT id, name FROM customer;")
    List <CustomerName> getCustomerName();

    // 获取品牌名称
    @Select("SELECT id, name FROM brand")
    List <BrandName> getBrandName();
}
