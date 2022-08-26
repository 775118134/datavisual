package com.hmm.mht.bladevisual.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.hmm.mht.bladevisual.model.BladeVisual;
import com.hmm.mht.bladevisual.service.BladeVisualConfigService;
import com.hmm.mht.bladevisual.service.BladeVisualService;
import com.hmm.mht.bladevisual.utils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * 可视化表
 */
@RestController
@RequestMapping("/bladeVisuals")
@Api(tags = "可视化表")
public class BladeVisualController {
    @Autowired
    private BladeVisualService bladeVisualService;

    @Autowired
    private BladeVisualConfigService bladeVisualConfigService;

    @GetMapping("/{id}")
    @ApiOperation("通过ID查询单个可视化表")
    public R<BladeVisual> findById(@ApiParam("ID") @PathVariable("id") String id) {
        return R.ok(bladeVisualService.findById(id));
    }

    @GetMapping
    @ApiOperation("分页查询可视化表")
    public IPage<BladeVisual> findByPage(@ApiParam("页号") @RequestParam(defaultValue = "1") Integer pageNum,
                                         @ApiParam("每页大小") @RequestParam(defaultValue = "10") Integer pageSize) {
        return bladeVisualService.findByPage(pageNum, pageSize);
    }

    @GetMapping("/category/{id}")
    @ApiOperation("根据category Id分页查询可视化表")
    public IPage<BladeVisual> findByCategoryAndPage(@ApiParam("ID") @PathVariable("id") String id, @ApiParam("页号") @RequestParam(defaultValue = "1") Integer pageNum,
                                                    @ApiParam("每页大小") @RequestParam(defaultValue = "10") Integer pageSize) {
        return bladeVisualService.findByCategoryAndPage(id, pageNum, pageSize);
    }

    @PutMapping
    @ApiOperation("修改可视化表")
    public void update(@RequestBody BladeVisual bladeVisual) {
        bladeVisualService.update(bladeVisual);
    }

    @DeleteMapping("/{id}")
    @ApiOperation("通过ID删除单个可视化表")
    public void deleteById(@ApiParam("ID") @Valid @PathVariable("id") String id) {
        bladeVisualService.deleteById(id);
    }

}
