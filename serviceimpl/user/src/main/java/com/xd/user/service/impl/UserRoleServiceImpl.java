package com.xd.user.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xd.user.mapper.UserRoleMapper;
import com.xd.user.api.entity.UserRole;
import com.xd.user.service.UserRoleService;
import org.springframework.stereotype.Service;

/**
 * 用户角色(UserRole)表服务实现类
 *
 * @author hbx
 * @since 2019-12-30 17:17:30
 */
@Service("userRoleService")
public class UserRoleServiceImpl extends ServiceImpl<UserRoleMapper, UserRole> implements UserRoleService {

}