package org.plan.managementservice.service;


import org.plan.managementfacade.model.infoModel.Range;
import org.plan.managementfacade.model.responseModel.*;
import org.plan.managementfacade.model.baseInfoModel.Brand;
import org.plan.managementfacade.model.baseInfoModel.ClothingLevel;
import org.plan.managementfacade.model.baseInfoModel.Customer;
import org.plan.managementfacade.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.plan.managementservice.mapper.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class InformationServiceImpl implements InformationService{

    @Autowired
    private InformationMapper informationMapper;

    @Override
    public List <CustomerName> getCustomerName() {
        // 获取客户名称
        List <Customer> customerResult = informationMapper.getAllCustomer();
        List <CustomerName> customerNameList = new ArrayList<>();
        for (Customer customer : customerResult){
            CustomerName customerName = new CustomerName();
            int id = customer.getId();
            String name = customer.getName();
            customerName.setId(id);
            customerName.setName(name);
            customerNameList.add(customerName);
        }
        return customerNameList;
    }

    @Override
    public List <Brand> getBrandName() {
        return null;
    }

    @Override
    public List <Range> getRangeName() {
        return null;
    }

    @Override
    public List <ClothingLevel> getClothingLevelName() {
        return null;
    }
}
