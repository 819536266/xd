package com.xd.user.api.fegin;


import com.xd.common.constant.ServiceConstant;
import com.xd.user.api.entity.UserRole;
import com.xd.common.base.BaseFegin;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * 用户角色(UserRole)表Fegin
 *
 * @author hbx
 * @since 2019-12-30 18:30:02
 */
@FeignClient(value = ServiceConstant.USER_SERVICE)
public interface UserRoleFegin extends BaseFegin<UserRole,String> {
    
}