package com.xd.user.controller;


import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.xd.common.base.BaseController;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.xd.user.api.entity.User;
import com.xd.user.api.fegin.UserFegin;
import com.xd.user.service.UserService;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.annotation.Transactional;
import javax.annotation.Resource;
import java.io.Serializable;
import java.sql.Wrapper;
import java.util.List;

/**
 * 用户(User)表控制层
 *
 * @author hbx
 * @since 2019-12-30 17:17:28
 */
@Slf4j
@RestController
@RequestMapping("user")
@Api(description="User")
@Transactional(rollbackFor = Exception.class)
public class UserController extends BaseController<UserService,User,String> implements UserFegin {

    @Resource
    private UserService userService;

    /**
     * 根据用户名获取用户
     * @param username 用户名
     * @return 用户信息
     */
    @GetMapping("/getUsername")
    @Override
    public R<User> getUsername( String username) {
        User one = userService.getOne(Wrappers
                .<User>lambdaQuery().eq(User::getUsername, username));
        return success(one);
    }
}