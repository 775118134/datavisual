package com.hmm.mht.bladevisual.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.hmm.mht.bladevisual.model.BladeVisualMap;
import com.hmm.mht.bladevisual.service.BladeVisualMapService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 可视化地图配置表
 */
@RestController
@RequestMapping("/bladeVisualMaps")
@Api(tags = "可视化地图配置表")
public class BladeVisualMapController {
    @Autowired
    private BladeVisualMapService bladeVisualMapService;

    @GetMapping("/{id}")
    @ApiOperation("通过ID查询单个可视化地图配置表")
    public BladeVisualMap findById(@ApiParam("ID") @PathVariable("id") String id) {
        return bladeVisualMapService.findById(id);
    }

    @GetMapping
    @ApiOperation("分页查询可视化地图配置表")
    public IPage<BladeVisualMap> findByPage(@ApiParam("页号") @RequestParam(defaultValue = "1") Integer pageNum,
                                            @ApiParam("每页大小") @RequestParam(defaultValue = "10") Integer pageSize) {
        return bladeVisualMapService.findByPage(pageNum, pageSize);
    }

    @PostMapping
    @ApiOperation("新增可视化地图配置表")
    public void insert(@RequestBody BladeVisualMap bladeVisualMap) {
        bladeVisualMapService.insert(bladeVisualMap);
    }

    @PutMapping
    @ApiOperation("修改可视化地图配置表")
    public void update(@RequestBody BladeVisualMap bladeVisualMap) {
        bladeVisualMapService.update(bladeVisualMap);
    }

    @DeleteMapping("/{id}")
    @ApiOperation("通过ID删除单个可视化地图配置表")
    public void deleteById(@ApiParam("ID") @PathVariable("id") String id) {
        bladeVisualMapService.deleteById(id);
    }
}
