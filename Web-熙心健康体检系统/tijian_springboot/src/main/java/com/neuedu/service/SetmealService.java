package com.neuedu.service;


import com.neuedu.po.Setmeal;

import java.util.List;

public interface SetmealService {

    public List<Setmeal> listSetmealByType(Integer type);
    public Setmeal getSetmealById(Integer smId);
}
