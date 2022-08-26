package com.hmm.mht.bladevisual.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 可视化地图配置表
 */
@Data
@Accessors(chain = true)
@TableName("blade_visual_map")
public class BladeVisualMap {
    /**
     * 主键
     */
    @TableId
    @TableField("id")
    private String id;
    /**
     * 地图名称
     */
    @TableField("name")
    private String name;
    /**
     * 地图数据
     */
    @TableField("data")
    private String data;
    /**
     * 是否已删除
     */
    @TableLogic
    @TableField("is_deleted")
    private boolean deleted;
}