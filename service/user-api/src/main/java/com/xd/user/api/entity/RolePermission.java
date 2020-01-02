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
 * @title: RolePermission
 * @projectName bk
 * @description: 角色权限实体
 * @date 2019/12/3016:51
 */
@Data
@Accessors(chain = true)
@TableName("xd_role_permission")
@Table(name = "xd_role_permission")
@org.hibernate.annotations.Table(appliesTo = "xd_role_permission",comment = "角色权限")
@Entity
@ApiModel("角色权限")
public class RolePermission extends BaseModel<RolePermission> {

    private static final long serialVersionUID = -5665366288936653303L;

    @ApiModelProperty(value = "角色id")
    @Column( nullable = false, columnDefinition = "varchar(100) default '' comment'角色id'")
    private String roleId;

    @ApiModelProperty(value = "权限id")
    @Column( nullable = false, columnDefinition = "varchar(100) default '' comment'权限id'")
    private String permissionId;
}