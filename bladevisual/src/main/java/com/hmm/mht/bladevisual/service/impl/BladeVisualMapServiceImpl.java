package com.hmm.mht.bladevisual.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hmm.mht.bladevisual.dao.BladeVisualMapDAO;
import com.hmm.mht.bladevisual.model.BladeVisualMap;
import com.hmm.mht.bladevisual.service.BladeVisualMapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = Exception.class)
public class BladeVisualMapServiceImpl extends ServiceImpl<BladeVisualMapDAO, BladeVisualMap> implements BladeVisualMapService {

    @Autowired
    private BladeVisualMapDAO bladeVisualMapDAO;

    @Transactional(readOnly = true)
    @Override
    public BladeVisualMap findById(String id) {
        return bladeVisualMapDAO.selectById(id);
    }

    @Transactional(readOnly = true)
    @Override
    public IPage<BladeVisualMap> findByPage(int pageNum, int pageSize) {
        return bladeVisualMapDAO.selectPage(new Page<>(pageNum, pageSize), null);
    }

    @Override
    public void insert(BladeVisualMap bladeVisualMap) {
        bladeVisualMapDAO.insert(bladeVisualMap);
    }

    @Override
    public void update(BladeVisualMap bladeVisualMap) {
        bladeVisualMapDAO.updateById(bladeVisualMap);
    }

    @Override
    public void deleteById(String id) {
        bladeVisualMapDAO.deleteById(id);
    }

}