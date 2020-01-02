package com.xd.user.api.fegin;


import com.xd.common.base.BaseFegin;
import com.xd.common.constant.ServiceConstant;
import com.xd.user.api.entity.Permission;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @author 15290
 */
//@FeignClient(value = ServiceConstant.USER_SERVICE)
public interface PermissionFegin extends BaseFegin<Permission,String> {
    
}