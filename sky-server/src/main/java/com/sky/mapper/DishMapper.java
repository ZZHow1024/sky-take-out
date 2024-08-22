package com.sky.mapper;

import com.sky.annotation.Autofill;
import com.sky.entity.Dish;
import com.sky.enumeration.OperationType;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @author ZZHow
 * @date 2024/8/18
 */
@Mapper
public interface DishMapper {

    /**
     * 根据分类 ID 查询菜品数量
     *
     * @param categoryId
     * @return
     */
    @Select("select count(`id`) from `dish` where `category_id` = #{categoryId}")
    Integer countByCategoryId(Long categoryId);

    /**
     * 插入菜品数据
     *
     * @param dish
     */
    @Autofill(value = OperationType.INSERT)
    void insert(Dish dish);
}
