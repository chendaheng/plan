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
    public List <BrandName> getBrandName() {
        // 获取品牌名称
        List <Brand> brandResult = informationMapper.getAllBrand();
        List <BrandName> brandNameList = new ArrayList<>();
        for (Brand brand : brandResult){
            BrandName brandName = new BrandName();
            int id = brand.getId();
            String name = brand.getName();
            brandName.setId(id);
            brandName.setName(name);
            brandNameList.add(brandName);
        }
        return brandNameList;
    }

    @Override
    public List<RangeName> getRangeName() {
        //  获取系列名称
        List <Range> rangeResult = informationMapper.getAllRange();
        List <RangeName> rangeNameList = new ArrayList<>();
        for (Range range : rangeResult){
            RangeName rangeName = new RangeName();
            int id = range.getId();
            String name = range.getName();
            rangeName.setId(id);
            rangeName.setName(name);
            rangeNameList.add(rangeName);
        }
        return rangeNameList;
    }

    @Override
    public List <ClothingLevelName> getClothingLevelName() {
        // 获取服装层次名称
        List <ClothingLevel> clothingLevelResult = informationMapper.getAllClothingLevel();
        List <ClothingLevelName> clothingLevelNameList = new ArrayList<>();
        for (ClothingLevel clothingLevel : clothingLevelResult){
            ClothingLevelName clothingLevelName = new ClothingLevelName();
            int id = clothingLevel.getId();
            String name = clothingLevel.getName();
            clothingLevelName.setId(id);
            clothingLevelName.setName(name);
            clothingLevelNameList.add(clothingLevelName);
        }
        return clothingLevelNameList;
    }
}
