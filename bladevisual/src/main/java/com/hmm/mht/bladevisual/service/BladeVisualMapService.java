package com.hmm.mht.bladevisual.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.hmm.mht.bladevisual.model.BladeVisualMap;

/**
 * 可视化地图配置表
 */
public interface BladeVisualMapService extends IService<BladeVisualMap> {

    /**
     * 通过ID查询单个可视化地图配置表
     *
     * @param id ID
     * @return {@link BladeVisualMap}
     */
    BladeVisualMap findById(String id);

    /**
     * 分页查询可视化地图配置表
     *
     * @param pageNum  页号
     * @param pageSize 每页大小
     * @return {@link BladeVisualMap}
     */
    IPage<BladeVisualMap> findByPage(int pageNum, int pageSize);

    /**
     * 新增可视化地图配置表
     *
     * @param bladeVisualMap 可视化地图配置表
     */
    void insert(BladeVisualMap bladeVisualMap);

    /**
     * 修改可视化地图配置表
     *
     * @param bladeVisualMap 可视化地图配置表
     */
    void update(BladeVisualMap bladeVisualMap);

    /**
     * 通过ID删除单个可视化地图配置表
     *
     * @param id ID
     */
    void deleteById(String id);

}