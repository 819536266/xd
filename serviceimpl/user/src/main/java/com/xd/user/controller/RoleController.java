package com.xd.user.controller;


import com.xd.common.base.BaseController;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.xd.user.api.entity.Role;
import com.xd.user.api.fegin.RoleFegin;
import com.xd.user.service.RoleService;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.annotation.Transactional;
import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * 用户角色(Role)表控制层
 *
 * @author hbx
 * @since 2019-12-30 17:17:24
 */
@Slf4j
@RestController
@RequestMapping("role")
@Api(description="Role")
@Transactional(rollbackFor = Exception.class)
public class RoleController extends BaseController<RoleService,Role,String> implements RoleFegin {
    
}