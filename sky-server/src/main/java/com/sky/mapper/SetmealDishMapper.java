package com.sky.mapper;

import com.sky.entity.SetmealDish;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

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
    List<Long> selectSetmealIdsByDishIds(List<Long> dishIds);

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

    /**
     * 根据套餐 ID 查询关联的菜品
     *
     * @param id
     * @return
     */
    @Select("select `copies`, `dish_id`, `id`, `name`, `price`, `setmeal_id` from `setmeal_dish` where `setmeal_id` = #{id}")
    List<SetmealDish> selectSetmealIdsByDishId(Long id);

    /**
     * 根据套餐 ID 删除菜品关系
     *
     * @param id
     */
    @Delete("delete from `setmeal_dish` where `setmeal_id` = #{id}")
    void deleteBySetmealId(Long id);

    /**
     * 批量插入套餐菜品关系
     *
     * @param setmealDishes
     */
    void insertBatch(List<SetmealDish> setmealDishes);
}
