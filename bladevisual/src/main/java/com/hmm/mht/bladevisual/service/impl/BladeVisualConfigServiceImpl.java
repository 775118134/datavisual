package com.hmm.mht.bladevisual.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hmm.mht.bladevisual.dao.BladeVisualConfigDAO;
import com.hmm.mht.bladevisual.model.BladeVisualConfig;
import com.hmm.mht.bladevisual.service.BladeVisualConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = Exception.class)
public class BladeVisualConfigServiceImpl extends ServiceImpl<BladeVisualConfigDAO, BladeVisualConfig> implements BladeVisualConfigService {

    @Autowired
    private BladeVisualConfigDAO bladeVisualConfigDAO;

    @Transactional(readOnly = true)
    @Override
    public BladeVisualConfig findById(String id) {
        return bladeVisualConfigDAO.selectById(id);
    }

    @Override
    public BladeVisualConfig findByVisualId(String visualId) {
        QueryWrapper<BladeVisualConfig> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("visual_id", visualId);
        return bladeVisualConfigDAO.selectOne(queryWrapper);
    }

    @Transactional(readOnly = true)
    @Override
    public IPage<BladeVisualConfig> findByPage(int pageNum, int pageSize) {
        return bladeVisualConfigDAO.selectPage(new Page<>(pageNum, pageSize), null);
    }

    @Override
    public void insert(BladeVisualConfig bladeVisualConfig) {
        bladeVisualConfigDAO.insert(bladeVisualConfig);
    }

    @Override
    public void update(BladeVisualConfig bladeVisualConfig) {
        bladeVisualConfigDAO.updateById(bladeVisualConfig);
    }

    @Override
    public void deleteById(String id) {
        bladeVisualConfigDAO.deleteById(id);
    }

}