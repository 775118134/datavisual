package com.hmm.mht.bladevisual.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 可视化配置表
 */
@Data
@Accessors(chain = true)
@TableName("blade_visual_config")
public class BladeVisualConfig {
    /**
     * 主键
     */
    @TableId
    @TableField("id")
    private String id;
    /**
     * 可视化表主键
     */
    @TableField("visual_id")
    private String visualId;
    /**
     * 配置json
     */
    @TableField("detail")
    private String detail;
    /**
     * 组件json
     */
    @TableField("component")
    private String component;
}