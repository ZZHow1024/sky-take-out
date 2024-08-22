package com.sky.mapper;

import com.github.pagehelper.Page;
import com.sky.annotation.Autofill;
import com.sky.dto.DishPageQueryDTO;
import com.sky.entity.Dish;
import com.sky.enumeration.OperationType;
import com.sky.vo.DishVO;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

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

    /**
     * 菜品分页查询
     *
     * @param dishPageQueryDTO
     * @return
     */
    Page<DishVO> selectPage(DishPageQueryDTO dishPageQueryDTO);

    /**
     * 根据 ID 查询菜品
     *
     * @param id
     * @return
     */
    @Select("select `id`, `name`, `category_id`, `price`, `image`, `description`, `status`, `create_time`, `update_time`, `create_user`, `update_user`" +
            " from `dish` where `id` = #{id}")
    Dish get(Long id);

    /**
     * 根据 ID 删除菜品
     *
     * @param id
     */
    @Delete("delete from `dish` where `id` = #{id}")
    void delete(Long id);

    /**
     * 根据 ID 列表批量删除菜品
     *
     * @param ids
     */
    void deleteBatch(List<Long> ids);
}
