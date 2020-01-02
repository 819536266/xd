package com.xd.user.api.fegin;


import com.xd.common.base.BaseController;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.xd.common.constant.ServiceConstant;
import com.xd.user.api.entity.User;
import com.xd.common.base.BaseFegin;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 用户(User)表Fegin
 *
 * @author hbx
 * @since 2019-12-30 18:30:02
 */
@FeignClient(value = ServiceConstant.USER_SERVICE,path = "user")
public interface UserFegin extends BaseFegin<User, String> {
    /**
     * 根据用户名获取用户
     * @param username 用户名
     * @return 用户信息
     */
    @GetMapping("/getUsername")
    R<User> getUsername(@RequestParam  String username);

}