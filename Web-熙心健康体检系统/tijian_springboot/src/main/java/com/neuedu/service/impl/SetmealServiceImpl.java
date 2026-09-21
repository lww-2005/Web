package com.neuedu.service.impl;

import com.neuedu.mapper.SetmealMapper;
import com.neuedu.po.Setmeal;
import com.neuedu.service.SetmealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SetmealServiceImpl implements SetmealService {

    @Autowired
    private SetmealMapper setmealMapper;

    @Override
    public List<Setmeal> listSetmealByType(Integer type) {
        return setmealMapper.listSetmealByType(type);
    }

    @Override
    public Setmeal getSetmealById(Integer smId) {
        return setmealMapper.getSetmealById(smId);
    }
}
