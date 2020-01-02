package com.xd.user.api.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.xd.common.base.BaseModel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.math.BigDecimal;
import java.util.List;

/**
 * @author huboxin
 * @title: Permission
 * @projectName bk
 * @description: 权限
 * @date 2019/12/3016:31
 */
@Data
@Accessors(chain = true)
@TableName("xd_permission")
@Table(name = "xd_permission")
@org.hibernate.annotations.Table(appliesTo = "xd_permission",comment = "权限")
@Entity
@ApiModel("权限")
public class Permission extends BaseModel<Permission> {

    private static final long serialVersionUID = -2961078926175041013L;
    @ApiModelProperty(value = "菜单/权限名称")
    @Column( nullable = false, columnDefinition = "varchar(255) default '' comment'菜单/权限名称'")
    private String name;

    @ApiModelProperty(value = "始终显示 默认是")
    @Column(name = "is_show_always",nullable = false, columnDefinition = "bit default true comment'始终显示 默认是'")
    private Boolean showAlways = true;

    @ApiModelProperty(value = "层级")
    @Column( nullable = false, columnDefinition = "Integer default true comment '层级 '")
    private Integer level;

    @ApiModelProperty(value = "类型 0页面 1具体操作")
    @Column( nullable = false, columnDefinition = "Integer(2) default 1 comment ' 类型 0页面 1具体操作 '")
    private Integer type;

    @ApiModelProperty(value = "菜单标题")
    @Column( nullable = false, columnDefinition = "varchar(100) default '' comment ' 菜单标题 '")
    private String title;

    @ApiModelProperty(value = "页面路径/资源链接url")
    @Column( nullable = false, columnDefinition = "varchar(1000) default '' comment '页面路径/资源链接url '")
    private String path;

    @ApiModelProperty(value = "前端组件")
    @Column( nullable = false, columnDefinition = "varchar(255) default  ''  comment '前端组件 '")
    private String component;

    @ApiModelProperty(value = "图标")
    @Column( nullable = false, columnDefinition = "varchar(255) default '' comment '图标 '")
    private String icon;

    @ApiModelProperty(value = "按钮权限类型")
    @Column( nullable = false, columnDefinition = "varchar(255) default '' comment '按钮权限类型 '")
    private String buttonType;

    @ApiModelProperty(value = "父id")
    @Column( nullable = false, columnDefinition = "varchar(255) default '' comment '父id '")
    private String parentId;


    @ApiModelProperty(value = "排序值")
    @Column(precision = 10, scale = 2,columnDefinition = "decimal default 0 comment '排序值 '")
    private BigDecimal sortOrder;

    @ApiModelProperty(value = "是否启用 0启用 -1禁用")
    @Column( nullable = false, columnDefinition = "Integer(2) default 0 comment '是否启用 0启用 -1禁用 '")
    private Integer status ;

    @ApiModelProperty(value = "网页链接")
    @Column( nullable = false, columnDefinition = "varchar(10000) default true comment '网页链接 '")
    private String url;

    @Transient
    @TableField(exist=false)
    @ApiModelProperty(value = "子菜单/权限")
    private List<Permission> children;

    @Transient
    @TableField(exist=false)
    @ApiModelProperty(value = "页面拥有的权限类型")
    private List<String> permTypes;

    @Transient
    @TableField(exist=false)
    @ApiModelProperty(value = "节点展开 前端所需")
    private Boolean expand = true;

    @Transient
    @TableField(exist=false)
    @ApiModelProperty(value = "是否勾选 前端所需")
    private Boolean checked = false;

    @Transient
    @TableField(exist=false)
    @ApiModelProperty(value = "是否选中 前端所需")
    private Boolean selected = false;

}