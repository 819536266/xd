package com.xd.user.api.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.xd.common.base.BaseModel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author huboxin
 * @title: Role
 * @projectName bk
 * @description: 角色实体类
 * @date 2019/12/3016:07
 */
@Data
@Accessors(chain = true)
@TableName("xd_role")
@Table(name = "xd_role")
@org.hibernate.annotations.Table(appliesTo = "xd_role",comment = "用户角色")
@Entity
@ApiModel("角色")
public class Role extends BaseModel<Role> {

    private static final long serialVersionUID = 2206300031262104057L;
    @ApiModelProperty(value = "角色名 以ROLE_开头")
    @Column( unique = true, nullable = false, columnDefinition = "varchar(100) default '' comment'角色名,以ROLE_开头'")
    private String name;

    @ApiModelProperty(value = "是否为注册默认角色")
    @Column( nullable = false, columnDefinition = "bit default false comment'是否为注册默认角色'")
    private Boolean defaultRole;

    @ApiModelProperty(value = "数据权限类型 0全部默认 1自定义")
    @Column( nullable = false, columnDefinition = "Integer default 0 comment'数据权限类型 0全部默认 1自定义'")
    private Integer dataType;

}
