package com.hmm.mht.bladevisual.controller;

import cn.hutool.json.JSONUtil;
import com.hmm.mht.bladevisual.model.BladeVisual;
import com.hmm.mht.bladevisual.model.BladeVisualConfig;
import com.hmm.mht.bladevisual.service.BladeVisualConfigService;
import com.hmm.mht.bladevisual.service.BladeVisualService;
import com.hmm.mht.bladevisual.utils.R;
import com.hmm.mht.bladevisual.vo.VisualVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.File;
import java.io.IOException;

/**
 * 可视化表
 */
@RestController
@RequestMapping("visualsDetail")
@Api(tags = "可视化详情表")
@Slf4j
public class BladeVisualDetailController {
    @Value("${file.upload.path}")
    private String uploadPath;

    @Value("${file.upload.baseUrl}")
    private String uploadBaseUrl;

    @Autowired
    private BladeVisualService bladeVisualService;

    @Autowired
    private BladeVisualConfigService bladeVisualConfigService;

    @PostMapping
    @ApiOperation("新增可视化详情表")
    @Transactional(timeout = 5)
    public R<Object> insert(@Valid @RequestBody VisualVO visualVO) {
        try {
            BladeVisual visual = visualVO.getVisual();
            bladeVisualService.insert(visual);
            BladeVisualConfig config = visualVO.getConfig();
            if (config != null) {
                config.setVisualId(visual.getId());
                bladeVisualConfigService.insert(config);
                return R.ok(JSONUtil.createObj().put("id", visual.getId()));
            }
        } catch (Exception e) {
            log.error(e.toString(), e);
        }
        return R.failed();
    }

    @PutMapping
    @ApiOperation("修改可视化详情表")
    @Transactional(timeout = 5)
    public R<Object> update(@Valid @RequestBody VisualVO visualVO) {
        try {
            bladeVisualService.update(visualVO.getVisual());
            bladeVisualConfigService.update(visualVO.getConfig());
            return R.ok();
        } catch (Exception e) {
            log.error(e.toString(), e);
        }
        return R.failed();

    }

    @GetMapping("/{id}")
    @ApiOperation("通过ID查询单个可视化详情表")
    public R<VisualVO> findById(@ApiParam("ID") @PathVariable("id") String id) {
        BladeVisual visual = bladeVisualService.findById(id);
        if (visual != null) {
            BladeVisualConfig config = bladeVisualConfigService.findByVisualId(visual.getId());
            return R.ok(new VisualVO(visual, config));
        }
        return R.failed();
    }


    @PostMapping("/upload")
    public R<Object> upload(@RequestParam("file") MultipartFile file) {
        if (!file.isEmpty()) {
            String fileName = file.getOriginalFilename();
            File dest = new File(uploadPath + fileName);
            try {
                file.transferTo(dest);
                return R.ok(JSONUtil.createObj().put("link", uploadBaseUrl + fileName));
            } catch (IOException e) {
                log.error(e.toString(), e);
            }
        }
        return R.failed("上传失败，请选择文件");
    }


    @PostMapping("/copy")
    @ApiOperation("复制可视化表")
    public R<Object> copyById(@ApiParam("ID") @RequestParam String id) {
        R<VisualVO> visualVOR = this.findById(id);
        VisualVO visualVO = visualVOR.getData();
        visualVO.getVisual().setId(null).setCreateTime(null).setUpdateTime(null);
        visualVO.getConfig().setId(null).setVisualId(null);
        return this.insert(visualVO);
    }
}
