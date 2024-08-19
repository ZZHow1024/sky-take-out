package com.sky.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @author ZZHow
 * @date 2024/8/18
 */
@Mapper
public interface SetmealMapper {

    /**
     * 根据分类 ID 查询套餐的数量
     *
     * @param categoryId
     * @return
     */
    @Select("select count(`id`) from `setmeal` where `category_id` = #{categoryId}")
    Integer countByCategoryId(Long categoryId);
}
