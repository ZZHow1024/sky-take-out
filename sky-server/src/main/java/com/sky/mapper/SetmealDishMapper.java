package com.sky.mapper;

import com.sky.annotation.Autofill;
import com.sky.entity.SetmealDish;
import com.sky.enumeration.OperationType;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author ZZHow
 * @date 2024/8/22
 */
@Mapper
public interface SetmealDishMapper {

    /**
     * 根据菜品 ID 查询套餐 ID
     *
     * @param dishIds
     * @return
     */
    List<Long> getSetmealIdsByDishIds(List<Long> dishIds);

    /**
     * 新增套餐菜品关系
     *
     * @param setmealDish
     */
    void insert(SetmealDish setmealDish);

    /**
     * 根据套餐 ID 批量删除菜品关系
     *
     * @param ids
     */
    void deleteBatchBySetmealId(List<Long> ids);
}
