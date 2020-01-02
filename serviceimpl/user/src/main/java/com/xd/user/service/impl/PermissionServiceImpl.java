package com.xd.user.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xd.user.mapper.PermissionMapper;
import com.xd.user.api.entity.Permission;
import com.xd.user.service.PermissionService;
import org.springframework.stereotype.Service;

/**
 * 权限(Permission)表服务实现类
 *
 * @author hbx
 * @since 2019-12-30 17:17:23
 */
@Service("permissionService")
public class PermissionServiceImpl extends ServiceImpl<PermissionMapper, Permission> implements PermissionService {

}