package com.xd.user.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xd.user.mapper.RoleMapper;
import com.xd.user.api.entity.Role;
import com.xd.user.service.RoleService;
import org.springframework.stereotype.Service;

/**
 * 用户角色(Role)表服务实现类
 *
 * @author hbx
 * @since 2019-12-30 17:17:25
 */
@Service("roleService")
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {

}