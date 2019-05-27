package org.plan.managementservice.service.authorityManagement.Imply;

import org.plan.managementfacade.model.authorityModel.AuthorityReq;
import org.plan.managementservice.general.ErrorCode;
import org.plan.managementservice.mapper.authorityManagement.AuthorityModifyMapper;
import org.plan.managementservice.mapper.baseInfoManagement.BaseInfoObtainMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class AuthorityModifyServiceImply {
    @Autowired
    private AuthorityModifyMapper authorityModifyMapper;
    @Autowired
    private BaseInfoObtainMapper baseInfoObtainMapper;

    @Transactional
    public int addUserDataAuthority (AuthorityReq authorityReq) {
        Integer userId = authorityReq.getUserId();
        String userName = authorityReq.getUserName();
        Integer customerId = authorityReq.getCustomerId();
        List<Integer> brandIdList = authorityReq.getBrandIdList();
        // 对传入的所有品牌找出它对应的customerId与传入的customerId比较,若不同则说明传入数据有问题,不插入数据
        for (Integer brandId : brandIdList) {
            Integer brandCustomerId = baseInfoObtainMapper.getCustomerIdByBrandId(brandId);
            if (!customerId.equals(brandCustomerId)) {
                return ErrorCode.dataInconsistency;
            }
        }
        int result = 0;
        for (Integer brandId : brandIdList) {
            int ret = addOneUserDataAuthority(userId, userName, customerId, brandId);
            if (ret > 0) {
                result += ret;
            }
        }
        return result;
    }

    public int deleteUserDataAuthority (int userId, int brandId) {
        return authorityModifyMapper.deleteUserDataAuthority(userId, brandId);
    }

    // 依据userId,userName,customerId,brandId直接添加权限记录
    private int addOneUserDataAuthority (Integer userId, String userName, Integer customerId, Integer brandId) {
        int result = 0;
        try {
            result = authorityModifyMapper.addUserDataAuthority(userId, userName, customerId, brandId);
        } catch (DuplicateKeyException e) {
            // 只对添加数据时出现的主键重复异常进行捕获,其他异常则回滚事务
            e.printStackTrace();
        }
        return result;
    }
}
