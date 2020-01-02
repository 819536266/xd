package com.xd.user.controller;


import com.xd.common.base.BaseController;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.xd.user.api.entity.RolePermission;
import com.xd.user.api.fegin.RolePermissionFegin;
import com.xd.user.service.RolePermissionService;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.annotation.Transactional;
import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * 角色权限(RolePermission)表控制层
 *
 * @author hbx
 * @since 2019-12-30 17:17:26
 */
@Slf4j
@RestController
@RequestMapping("rolePermission")
@Api(description="RolePermission")
@Transactional(rollbackFor = Exception.class)
public class RolePermissionController extends BaseController<RolePermissionService,RolePermission,String> implements RolePermissionFegin {
    
}