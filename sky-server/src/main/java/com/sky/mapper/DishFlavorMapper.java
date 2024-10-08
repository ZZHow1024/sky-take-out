package com.sky.mapper;

import com.sky.entity.DishFlavor;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author ZZHow
 * @date 2024/8/21
 */
@Mapper
public interface DishFlavorMapper {
    /**
     * 批量插入口味数据
     *
     * @param flavors
     */
    void insertBatch(List<DishFlavor> flavors);

    /**
     * 根据菜品 ID 删除口味
     *
     * @param dishId
     */
    @Delete("delete from `dish_flavor` where `dish_id` = #{dishId}")
    void deleteByDishId(Long dishId);

    /**
     * 根据菜品 ID 列表批量删除口味
     *
     * @param dishIds
     */
    void deleteByDishIds(List<Long> dishIds);

    /**
     * 根据菜品 ID 查询口味数据
     *
     * @param dishId
     * @return
     */
    @Select("select `id`, `dish_id`, `name`, `value`" +
            " from `dish_flavor` where `dish_id` = #{dishId}")
    List<DishFlavor> getByDishId(Long dishId);
}
