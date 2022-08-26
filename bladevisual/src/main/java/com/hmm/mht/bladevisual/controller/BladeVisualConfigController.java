package com.hmm.mht.bladevisual.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.hmm.mht.bladevisual.model.BladeVisualConfig;
import com.hmm.mht.bladevisual.service.BladeVisualConfigService;
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
 * 可视化配置表
 */
@RestController
@RequestMapping("/bladeVisualConfigs")
@Api(tags = "可视化配置表")
public class BladeVisualConfigController {
    @Autowired
    private BladeVisualConfigService bladeVisualConfigService;

    @GetMapping("/{id}")
    @ApiOperation("通过ID查询单个可视化配置表")
    public BladeVisualConfig findById(@ApiParam("ID") @PathVariable("id") String id) {
        return bladeVisualConfigService.findById(id);
    }

    @GetMapping
    @ApiOperation("分页查询可视化配置表")
    public IPage<BladeVisualConfig> findByPage(@ApiParam("页号") @RequestParam(defaultValue = "1") Integer pageNum,
                                               @ApiParam("每页大小") @RequestParam(defaultValue = "10") Integer pageSize) {
        return bladeVisualConfigService.findByPage(pageNum, pageSize);
    }

    @PostMapping
    @ApiOperation("新增可视化配置表")
    public void insert(@RequestBody BladeVisualConfig bladeVisualConfig) {
        bladeVisualConfigService.insert(bladeVisualConfig);
    }

    @PutMapping
    @ApiOperation("修改可视化配置表")
    public void update(@RequestBody BladeVisualConfig bladeVisualConfig) {
        bladeVisualConfigService.update(bladeVisualConfig);
    }

    @DeleteMapping("/{id}")
    @ApiOperation("通过ID删除单个可视化配置表")
    public void deleteById(@ApiParam("ID") @PathVariable("id") String id) {
        bladeVisualConfigService.deleteById(id);
    }
}
