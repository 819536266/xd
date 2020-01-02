package com.xd.user.controller;


import com.xd.common.base.BaseController;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.xd.user.api.entity.Permission;
import com.xd.user.api.fegin.PermissionFegin;
import com.xd.user.service.PermissionService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.annotation.Transactional;
import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * 权限(Permission)表控制层
 *
 * @author hbx
 * @since 2019-12-30 17:17:21
 */
@Slf4j
@RestController
@RequestMapping("permission")
@Api(description="Permission")
@Transactional(rollbackFor = Exception.class)
public class PermissionController extends BaseController<PermissionService,Permission,String> implements PermissionFegin {
    
}