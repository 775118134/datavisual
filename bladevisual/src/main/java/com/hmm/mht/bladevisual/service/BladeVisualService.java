package com.hmm.mht.bladevisual.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.hmm.mht.bladevisual.model.BladeVisual;

/**
 * 可视化表
 */
public interface BladeVisualService extends IService<BladeVisual> {

    /**
     * 通过ID查询单个可视化表
     *
     * @param id ID
     * @return {@link BladeVisual}
     */
    BladeVisual findById(String id);

    /**
     * 分页查询可视化表
     *
     * @param pageNum  页号
     * @param pageSize 每页大小
     * @return {@link BladeVisual}
     */
    IPage<BladeVisual> findByPage(int pageNum, int pageSize);

    /**
     * 根据category id 分页查询可视化表
     *
     * @param id
     * @param pageNum
     * @param pageSize
     * @return
     */
    IPage<BladeVisual> findByCategoryAndPage(String id, int pageNum, int pageSize);

    /**
     * 新增可视化表
     *
     * @param bladeVisual 可视化表
     */
    void insert(BladeVisual bladeVisual);

    /**
     * 修改可视化表
     *
     * @param bladeVisual 可视化表
     */
    void update(BladeVisual bladeVisual);

    /**
     * 通过ID删除单个可视化表
     *
     * @param id ID
     */
    void deleteById(String id);

}