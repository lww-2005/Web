package com.neuedu.mapper;

import com.neuedu.po.SetmealDetailed;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SetmealDetailedMapper {

    public List<SetmealDetailed> listSetmealDetailedBySmId(Integer smId);
}
