package com.hmm.mht.bladevisual.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * 可视化表
 */
@Data
@Accessors(chain = true)
@TableName("blade_visual")
public class BladeVisual {
    /**
     * 主键
     */
    @TableId
    @TableField("id")
    private String id;
    /**
     * 大屏标题
     */
    @TableField("title")
    private String title;
    /**
     * 大屏背景
     */
    @TableField("background_url")
    private String backgroundUrl;
    /**
     * 大屏类型
     */
    @TableField("category")
    private String category;
    /**
     * 发布密码
     */
    @TableField("password")
    private String password;
    /**
     * 创建人
     */
    @TableField("create_user")
    private Long createUser;
    /**
     * 创建部门
     */
    @TableField("create_dept")
    private Long createDept;
    /**
     * 创建时间
     */
    @TableField("create_time")
    private Date createTime;
    /**
     * 修改人
     */
    @TableField("update_user")
    private Long updateUser;
    /**
     * 修改时间
     */
    @TableField("update_time")
    private Date updateTime;
    /**
     * 状态
     */
    @TableField("status")
    private Integer status;
    /**
     * 是否已删除
     */
    @TableLogic
    @TableField("is_deleted")
    private boolean deleted;
}