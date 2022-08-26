package com.hmm.mht.bladevisual.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.hmm.mht.bladevisual.model.BladeVisualConfig;

/**
 * 可视化配置表
 */
public interface BladeVisualConfigService extends IService<BladeVisualConfig> {

    /**
     * 通过ID查询单个可视化配置表
     *
     * @param id ID
     * @return {@link BladeVisualConfig}
     */
    BladeVisualConfig findById(String id);


    /**
     * 通过ID查询单个可视化配置表
     *
     * @param visualId ID
     * @return {@link BladeVisualConfig}
     */
    BladeVisualConfig findByVisualId(String visualId);


    /**
     * 分页查询可视化配置表
     *
     * @param pageNum  页号
     * @param pageSize 每页大小
     * @return {@link BladeVisualConfig}
     */
    IPage<BladeVisualConfig> findByPage(int pageNum, int pageSize);

    /**
     * 新增可视化配置表
     *
     * @param bladeVisualConfig 可视化配置表
     */
    void insert(BladeVisualConfig bladeVisualConfig);

    /**
     * 修改可视化配置表
     *
     * @param bladeVisualConfig 可视化配置表
     */
    void update(BladeVisualConfig bladeVisualConfig);

    /**
     * 通过ID删除单个可视化配置表
     *
     * @param id ID
     */
    void deleteById(String id);

}