package com.hmm.mht.bladevisual.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hmm.mht.bladevisual.dao.BladeVisualDAO;
import com.hmm.mht.bladevisual.model.BladeVisual;
import com.hmm.mht.bladevisual.service.BladeVisualService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = Exception.class)
public class BladeVisualServiceImpl extends ServiceImpl<BladeVisualDAO, BladeVisual> implements BladeVisualService {

    @Autowired
    private BladeVisualDAO bladeVisualDAO;

    @Transactional(readOnly = true)
    @Override
    public BladeVisual findById(String id) {
        return bladeVisualDAO.selectById(id);
    }

    @Transactional(readOnly = true)
    @Override
    public IPage<BladeVisual> findByPage(int pageNum, int pageSize) {
        return bladeVisualDAO.selectPage(new Page<>(pageNum, pageSize), null);
    }

    @Override
    public IPage<BladeVisual> findByCategoryAndPage(@Param("category") String id, @Param("id") int pageNum, int pageSize) {
        QueryWrapper<BladeVisual> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("category", id);
        queryWrapper.orderByDesc("update_time");
        return bladeVisualDAO.selectPage(new Page<>(pageNum, pageSize, true), queryWrapper);
    }

    @Override
    public void insert(BladeVisual bladeVisual) {
        bladeVisualDAO.insert(bladeVisual);
    }

    @Override
    public void update(BladeVisual bladeVisual) {
        bladeVisualDAO.updateById(bladeVisual);
    }

    @Override
    public void deleteById(String id) {
        bladeVisualDAO.deleteById(id);
    }

}