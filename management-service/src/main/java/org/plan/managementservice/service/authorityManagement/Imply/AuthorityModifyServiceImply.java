package org.plan.managementservice.service.authorityManagement.Imply;

import org.plan.managementfacade.model.authorityModel.AuthorityReq;
import org.plan.managementservice.general.ErrorCode;
import org.plan.managementservice.mapper.authorityManagement.AuthorityModifyMapper;
import org.plan.managementservice.mapper.authorityManagement.AuthorityObtainMapper;
import org.plan.managementservice.mapper.baseInfoManagement.BaseInfoObtainMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AuthorityModifyServiceImply {
    @Autowired
    private AuthorityModifyMapper authorityModifyMapper;
    @Autowired
    private AuthorityObtainMapper authorityObtainMapper;
    @Autowired
    private BaseInfoObtainMapper baseInfoObtainMapper;

    public int addUserDataAuthority (AuthorityReq authorityReq) {
        Integer customerId = authorityReq.getCustomerId();
        Integer brandId = authorityReq.getBrandId();
        if (authorityReq.getBrandId() != 0) {
            // brandId不为0时需确保用户对品牌的操作权限在所拥有的客户权限之下
            if (!customerId.equals(baseInfoObtainMapper.getCustomerIdByBrandId(brandId))) {
                return ErrorCode.dataInconsistency;
            } else {
                return addOneUserDataAuthority(authorityReq);
            }
        } else {
            //brandId为0表示用户对该客户下的全部品牌均有操作权限
            int result = 0;//result表示添加记录数
            List<Integer> brandIdList = baseInfoObtainMapper.getBrandIdByCustomerId(authorityReq.getCustomerId());
            for (Integer i : brandIdList) {
                //将每个brandId对应权限依此加入数据库
                authorityReq.setBrandId(i);
                int ret = addOneUserDataAuthority(authorityReq);
                if (ret > 0) {
                    result++;//仅记录成功记录，失败则跳过
                }
            }
            return result;
        }
    }

    public int deleteUserDataAuthority (int id) {
        return authorityModifyMapper.deleteUserDataAuthority(id);
    }


    //依据userId,customerId,brandId直接添加权限记录
    private int addOneUserDataAuthority (AuthorityReq authorityReq) {
        int count = authorityObtainMapper.getUserAuthorityCountByUserIdAndBrandId(authorityReq.getUserId(), authorityReq.getBrandId()).size();
        if (count > 0) {
            //count大于0表示当前userId与brandId已存在，返回数据重复错误
            return ErrorCode.paramDuplication;
        } else {
            //否则添加数据
            return authorityModifyMapper.addUserDataAuthority(authorityReq);
        }
    }
}
