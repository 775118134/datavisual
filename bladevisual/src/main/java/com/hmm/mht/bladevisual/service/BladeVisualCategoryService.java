package com.hmm.mht.bladevisual.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.hmm.mht.bladevisual.model.BladeVisualCategory;

/**
 * 可视化分类表
 */
public interface BladeVisualCategoryService extends IService<BladeVisualCategory> {

    /**
     * 通过ID查询单个可视化分类表
     *
     * @param id ID
     * @return {@link BladeVisualCategory}
     */
    BladeVisualCategory findById(String id);

    /**
     * 分页查询可视化分类表
     *
     * @param pageNum  页号
     * @param pageSize 每页大小
     * @return {@link BladeVisualCategory}
     */
    IPage<BladeVisualCategory> findByPage(int pageNum, int pageSize);


    /**
     * 新增可视化分类表
     *
     * @param bladeVisualCategory 可视化分类表
     */
    void insert(BladeVisualCategory bladeVisualCategory);

    /**
     * 修改可视化分类表
     *
     * @param bladeVisualCategory 可视化分类表
     */
    void update(BladeVisualCategory bladeVisualCategory);

    /**
     * 通过ID删除单个可视化分类表
     *
     * @param id ID
     */
    void deleteById(String id);

}