package com.hmm.mht.bladevisual.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hmm.mht.bladevisual.dao.BladeVisualCategoryDAO;
import com.hmm.mht.bladevisual.model.BladeVisualCategory;
import com.hmm.mht.bladevisual.service.BladeVisualCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = Exception.class)
public class BladeVisualCategoryServiceImpl extends ServiceImpl<BladeVisualCategoryDAO, BladeVisualCategory> implements BladeVisualCategoryService {

    @Autowired
    private BladeVisualCategoryDAO bladeVisualCategoryDAO;

    @Transactional(readOnly = true)
    @Override
    public BladeVisualCategory findById(String id) {
        return bladeVisualCategoryDAO.selectById(id);
    }

    @Transactional(readOnly = true)
    @Override
    public IPage<BladeVisualCategory> findByPage(int pageNum, int pageSize) {
        return bladeVisualCategoryDAO.selectPage(new Page<>(pageNum, pageSize), null);
    }

    @Override
    public void insert(BladeVisualCategory bladeVisualCategory) {
        bladeVisualCategoryDAO.insert(bladeVisualCategory);
    }

    @Override
    public void update(BladeVisualCategory bladeVisualCategory) {
        bladeVisualCategoryDAO.updateById(bladeVisualCategory);
    }

    @Override
    public void deleteById(String id) {
        bladeVisualCategoryDAO.deleteById(id);
    }

}