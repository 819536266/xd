package com.xd.user.api.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.xd.common.base.BaseModel;
import com.xd.common.constant.CommonConstant;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotBlank;
import java.util.List;

/**
 * @author huboxin
 * @title: User
 * @projectName bk
 * @description: 用戶
 * @date 2019/12/2715:30
 */
@Data
@Accessors(chain = true)
@TableName("xd_user")
@Table(name = "xd_user")
@org.hibernate.annotations.Table(appliesTo = "xd_user",comment = "用户")
@Entity
@ApiModel("用戶")
public class User extends BaseModel<User> {

    private static final long serialVersionUID = 1L;

    /**
     * 用户名
     */
    @Column(name = "username", unique = true, nullable = false, columnDefinition = "varchar(255) default '' comment'用户名'")
    @ApiModelProperty("用户名")
    @NotBlank(message = "用户名不可为空")
    private String username;

    /**
     * 密码
     */
    @ApiModelProperty("密码")
    @Column(name = "password", nullable = false, columnDefinition = "varchar(200) default '' comment '密码'")
    @NotBlank(message = "密码不可为空")
    private String password;

    /**
     * 昵称
     */
    @ApiModelProperty("昵称")
    @NotBlank(message = "昵称不可为空")
    @Column( columnDefinition = "varchar(200) default '' comment '昵称'")
    private String nickName;

    /**
     * 电话
     */
    @ApiModelProperty("电话")
    @NotBlank(message = "电话不可为空")
    @Column( columnDefinition = "varchar(20) default '' comment '电话'")
    private String mobile;

    /**
     * 邮箱
     */
    @ApiModelProperty("邮箱")
    @NotBlank(message = "邮箱不可为空")
    @Column( columnDefinition = "varchar(100) default '' comment '邮箱'")
    private String email;

    /**
     * 省市县地址
     */
    @ApiModelProperty("省市县地址")
    @Column( columnDefinition = "varchar(100) default '' comment '省市县地址'")
    private String address;

    /**
     * 街道地址
     */
    @ApiModelProperty("街道地址")
    @Column( columnDefinition = "varchar(255) default '' comment '街道地址'")
    private String street;

    /**
     * 性别
     */
    @ApiModelProperty("性别")
    @Column( columnDefinition = "varchar(5) default '' comment '性别'")
    private String sex;

    /**
     * 密码强度
     */
    @ApiModelProperty("密码强度")
    @Column( columnDefinition = "varchar(2) default '' comment '密码强度'")
    private String passStrength;

    /**
     * 用户头像
     */
    @ApiModelProperty("用户头像")
    @Column( columnDefinition = "varchar(1000) default '' comment '用户头像'")
    private String avatar= CommonConstant.USER_DEFAULT_AVATAR;

    /**
     * 用户类型
     */
    @ApiModelProperty("用户类型 0普通用户 1管理员")
    @Column( columnDefinition = "Integer(2) default 0 comment '用户类型 0普通用户 1管理员'")
    private Integer type=CommonConstant.USER_TYPE_NORMAL;

    /**
     * 状态
     */
    @ApiModelProperty("状态 默认0 正常 -1拉黑")
    @Column( columnDefinition = "Integer(2) default 0 comment '状态 默认0 正常 -1拉黑'")
    private Integer status=CommonConstant.USER_STATUS_NORMAL;
    /**
     * 描述/详情/备注
     */
    @ApiModelProperty("详情/描述/备注")
    @Column( columnDefinition = "varchar(255) default '' comment '详情/描述/备注'")
    private String description;

    /**
     * 部门
     */
    @ApiModelProperty("部门")
    @Column( columnDefinition = "varchar(255) default '' comment '部门'")
    private String departmentId;

    @Transient
    @TableField(exist=false)
    @ApiModelProperty(value = "用户拥有角色")
    private List<Role> roles;

    @Transient
    @TableField(exist=false)
    @ApiModelProperty(value = "用户拥有的权限")
    private List<Permission> permissions;
}