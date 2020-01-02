package com.xd.user.api.fegin;


import com.xd.common.base.BaseController;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.xd.common.constant.ServiceConstant;
import com.xd.user.api.entity.RolePermission;
import com.xd.common.base.BaseFegin;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * 角色权限(RolePermission)表Fegin
 *
 * @author hbx
 * @since 2019-12-30 18:30:02
 */
//@FeignClient(value = ServiceConstant.USER_SERVICE)
public interface RolePermissionFegin extends BaseFegin<RolePermission,String> {
    
}