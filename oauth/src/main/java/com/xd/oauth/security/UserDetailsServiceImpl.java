package com.xd.oauth.security;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.extension.api.R;
import com.xd.common.Exception.TokenException;
import com.xd.common.constant.CommonConstant;
import com.xd.user.api.entity.Permission;
import com.xd.user.api.entity.Role;
import com.xd.user.api.entity.User;
import com.xd.user.api.fegin.UserFegin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.List;

/**
 * @author huboxin
 * @title: UserDetailsServiceImpl
 * @projectName bk
 * @description: UserDetails
 * @date 2019/12/3114:19
 */
@Component
public class UserDetailsServiceImpl implements UserDetailsService {

    @Resource
    private ClientDetailsService clientDetailsService;

    @Autowired
    private UserFegin userClient;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(authentication==null){
            ClientDetails clientDetails = clientDetailsService.loadClientByClientId(username);
            if(clientDetails!=null){
                String clientSecret = clientDetails.getClientSecret();
                return new org.springframework.security.core.userdetails.User(username,clientSecret, AuthorityUtils.commaSeparatedStringToAuthorityList(""));
            }
        }
        if(StrUtil.isEmpty(username)){
            throw new TokenException("没有用户名!");
        }
        R<User> rUser = userClient.getUsername(username);
        if(!rUser.ok()){
            throw new TokenException("授权失败!");
        }
        User user = rUser.getData();
        if(ObjectUtil.isEmpty(user) || ObjectUtil.isEmpty(user.getId())){
            throw new TokenException("授权用户不存在呦!");
        }
        return new SecurityUserDetails(username,user.getPassword(),getAuthorities(user),user);
    }

    /**
     * 获取权限
     * @param user 用户
     * @return 权限集合
     */
    private Collection<? extends GrantedAuthority> getAuthorities(User user) {
        List<GrantedAuthority> authorityList = CollUtil.newArrayList();
        List<Permission> permissions = user.getPermissions();
        // 添加请求权限
        if(permissions!=null&&permissions.size()>0){
            for (Permission permission : permissions) {
                if(CommonConstant.PERMISSION_OPERATION.equals(permission.getType())
                        && StrUtil.isNotBlank(permission.getTitle())
                        &&StrUtil.isNotBlank(permission.getPath())) {

                    authorityList.add(new SimpleGrantedAuthority(permission.getTitle()));
                }
            }
        }
        // 添加角色
        List<Role> roles = user.getRoles();
        if(roles!=null&&roles.size()>0){
            // lambda表达式
            roles.forEach(item -> {
                if(StrUtil.isNotBlank(item.getName())){
                    authorityList.add(new SimpleGrantedAuthority(item.getName()));
                }
            });
        }
        return authorityList;
    }

    @Bean
    private BCryptPasswordEncoder bCryptPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
