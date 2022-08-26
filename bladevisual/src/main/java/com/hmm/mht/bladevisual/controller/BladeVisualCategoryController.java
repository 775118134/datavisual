package com.hmm.mht.bladevisual.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.hmm.mht.bladevisual.model.BladeVisualCategory;
import com.hmm.mht.bladevisual.service.BladeVisualCategoryService;
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

import java.util.List;

/**
 * 可视化分类表
 */
@RestController
@RequestMapping("/bladeVisualCategorys")
@Api(tags = "可视化分类表")
public class BladeVisualCategoryController {
    @Autowired
    private BladeVisualCategoryService bladeVisualCategoryService;

    @GetMapping("list")
    @ApiOperation("获取全部可视化分类表")
    public List<BladeVisualCategory> list() {
        return bladeVisualCategoryService.list();
    }

    @GetMapping("/{id}")
    @ApiOperation("通过ID查询单个可视化分类表")
    public BladeVisualCategory findById(@ApiParam("ID") @PathVariable("id") String id) {
        return bladeVisualCategoryService.findById(id);
    }

    @GetMapping
    @ApiOperation("分页查询可视化分类表")
    public IPage<BladeVisualCategory> findByPage(@ApiParam("页号") @RequestParam(defaultValue = "1") Integer pageNum,
                                                 @ApiParam("每页大小") @RequestParam(defaultValue = "10") Integer pageSize) {
        return bladeVisualCategoryService.findByPage(pageNum, pageSize);
    }

    @PostMapping
    @ApiOperation("新增可视化分类表")
    public void insert(@RequestBody BladeVisualCategory bladeVisualCategory) {
        bladeVisualCategoryService.insert(bladeVisualCategory);
    }

    @PutMapping
    @ApiOperation("修改可视化分类表")
    public void update(@RequestBody BladeVisualCategory bladeVisualCategory) {
        bladeVisualCategoryService.update(bladeVisualCategory);
    }

    @DeleteMapping("/{id}")
    @ApiOperation("通过ID删除单个可视化分类表")
    public void deleteById(@ApiParam("ID") @PathVariable("id") String id) {
        bladeVisualCategoryService.deleteById(id);
    }
}
