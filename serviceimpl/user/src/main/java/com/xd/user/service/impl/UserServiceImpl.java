package com.xd.user.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xd.user.mapper.UserMapper;
import com.xd.user.api.entity.User;
import com.xd.user.service.UserService;
import org.springframework.stereotype.Service;

/**
 * 用户(User)表服务实现类
 *
 * @author hbx
 * @since 2019-12-30 17:17:29
 */
@Service("userService")
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}