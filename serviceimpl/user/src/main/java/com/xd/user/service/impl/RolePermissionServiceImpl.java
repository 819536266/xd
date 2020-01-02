package com.xd.user.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xd.user.mapper.RolePermissionMapper;
import com.xd.user.api.entity.RolePermission;
import com.xd.user.service.RolePermissionService;
import org.springframework.stereotype.Service;

/**
 * 角色权限(RolePermission)表服务实现类
 *
 * @author hbx
 * @since 2019-12-30 17:17:27
 */
@Service("rolePermissionService")
public class RolePermissionServiceImpl extends ServiceImpl<RolePermissionMapper, RolePermission> implements RolePermissionService {

}