package com.xd.common.config.mybatisplus;

import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author huboxin
 * @title: MyObjectHandler
 * @projectName bk
 * @description: mybatis-plus字段填充审计
 * @date 2019/12/2813:41
 */

@Slf4j
@Configuration
public class MyObjectHandler implements MetaObjectHandler {

    /**
     * 分页插件，自动识别数据库类型
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }

    @Override
    public void insertFill(MetaObject metaObject) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(ObjectUtil.isEmpty(authentication)){
           UserDetails userDetails= (UserDetails) authentication.getPrincipal();
           this.setFieldValByName("createBy", userDetails.getUsername(), metaObject);
        }
        this.setFieldValByName("createTime", new Date(), metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(ObjectUtil.isEmpty(authentication)){
            UserDetails userDetails= (UserDetails) authentication.getPrincipal();
            this.setFieldValByName("updateBy", userDetails.getUsername(), metaObject);
        }
        this.setFieldValByName("updateTime", new Date(), metaObject);
    }
}
