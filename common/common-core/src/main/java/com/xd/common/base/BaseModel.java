package com.xd.common.base;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.xd.common.constant.CommonConstant;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@Data
@MappedSuperclass
/** jpa自动审计填充字段*/
@EntityListeners(AuditingEntityListener.class)
/**忽略类中不存在的字段*/
@JsonIgnoreProperties(value={"hibernateLazyInitializer","handler","fieldHandler"})
/**
 * @author huboxin
 * @title: BaseModel
 * @projectName bk
 * @description:
 * @date 2019/12/289:58
 *
 */
public abstract class BaseModel<T extends BaseModel<?>> extends Model<T> implements Serializable {
    private static final long serialVersionUID = -5866498282789878008L;

    /**
     * 唯一标识
     * IdType.ID_WORKER_STR 分布式全局唯一ID 字符串类型
     */
    @Id
    @TableId(type = IdType.ID_WORKER_STR)
    @ApiModelProperty("唯一标识")
    @Column(columnDefinition = "varchar(200) comment '主键'")
    private String id;
    /**
     * 创建者
     */
    @ApiModelProperty(value = "创建者")
    @CreatedBy
    @TableField(fill = FieldFill.INSERT)
    @Column(name = "create_by",columnDefinition = "varchar(200) comment '创建者'")
    private String createBy;
    /**
     * 创建时间
     */
    @CreatedDate
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "创建时间")
    @TableField(fill = FieldFill.INSERT)
    @Column(name = "create_time",columnDefinition = "datetime comment '创建时间'")
    private Date createTime;

    /**
     * 更新者
     */
    @LastModifiedBy
    @ApiModelProperty(value = "更新者")
    @TableField(fill = FieldFill.UPDATE)
    @Column(name = "update_by",columnDefinition = "varchar(200) comment '更新者'")
    private String updateBy;

    /**
     * 更新时间
     */
    @LastModifiedDate
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "更新时间")
    @TableField(fill = FieldFill.UPDATE)
    @Column(name = "update_time",columnDefinition = "datetime comment '更新时间'")
    private Date updateTime;

    /**
     * 备注
     */
    @Column(name="common",columnDefinition = "varchar(255) comment'备注'")
    @ApiModelProperty("备注")
    private String common;

    /**
     * 删除标志
     */
    @ApiModelProperty(value = "删除标志 默认0")
    @Column(nullable = false,columnDefinition = "Integer(2) default 0 comment'删除标志 默认0'")
    private Integer delFlag = CommonConstant.STATUS_NORMAL;
}
