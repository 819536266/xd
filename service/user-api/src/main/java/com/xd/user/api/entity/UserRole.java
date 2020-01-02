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
 * @title: UserRole
 * @projectName bk
 * @description: 用户角色关联实体
 * @date 2019/12/3016:28
 */
@Data
@Accessors(chain = true)
@TableName("xd_user_role")
@Table(name = "xd_user_role")
@org.hibernate.annotations.Table(appliesTo = "xd_user_role",comment = "用户角色")
@Entity
@ApiModel("用户角色")
public class UserRole extends BaseModel<UserRole> {

    private static final long serialVersionUID = -8532130527835197305L;
    @ApiModelProperty(value = "用户唯一id")
    @Column( nullable = false, columnDefinition = "varchar(100) default '' comment '用户唯一id'")
    private String userId;

    @ApiModelProperty(value = "角色唯一id")
    @Column( nullable = false, columnDefinition = "varchar(100) default ''  comment '角色唯一id'")
    private String roleId;
}
