package com.xd.user.controller;


import com.xd.common.base.BaseController;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.xd.user.api.entity.UserRole;
import com.xd.user.api.fegin.UserRoleFegin;
import com.xd.user.service.UserRoleService;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.annotation.Transactional;
import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * 用户角色(UserRole)表控制层
 *
 * @author hbx
 * @since 2019-12-30 17:17:30
 */
@Slf4j
@RestController
@RequestMapping("userRole")
@Api(description="UserRole")
@Transactional(rollbackFor = Exception.class)
public class UserRoleController extends BaseController<UserRoleService,UserRole,String> implements UserRoleFegin {
    
}