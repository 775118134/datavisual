package com.hmm.mht.bladevisual.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 可视化分类表
 */
@Data
@Accessors(chain = true)
@TableName("blade_visual_category")
public class BladeVisualCategory {
    /**
     * 主键
     */
    @TableId
    @TableField("id")
    private String id;
    /**
     * 分类键值
     */
    @TableField("category_key")
    private String categoryKey;
    /**
     * 分类名称
     */
    @TableField("category_value")
    private String categoryValue;
    /**
     * 是否已删除
     */
    @TableLogic
    @TableField("is_deleted")
    private boolean deleted;
}