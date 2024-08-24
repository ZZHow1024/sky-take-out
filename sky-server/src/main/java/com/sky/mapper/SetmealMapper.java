package com.sky.mapper;

import com.github.pagehelper.Page;
import com.sky.annotation.Autofill;
import com.sky.dto.SetmealPageQueryDTO;
import com.sky.entity.Setmeal;
import com.sky.enumeration.OperationType;
import com.sky.vo.SetmealVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

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

    /**
     * 新增套餐
     *
     * @param setmeal
     */
    @Autofill(OperationType.INSERT)
    void insert(Setmeal setmeal);

    /**
     * 套餐分页查询
     *
     * @param setmealPageQueryDTO
     * @return
     */
    Page<SetmealVO> selectPage(SetmealPageQueryDTO setmealPageQueryDTO);

    /**
     * 根据 ID 获取套餐状态
     *
     * @param id
     * @return
     */
    @Select("select `status` from `setmeal` where `id` = #{id}")
    Integer getStatus(Long id);

    /**
     * 批量删除套餐
     *
     * @param ids
     */
    void deleteBatch(List<Long> ids);

    /**
     * 根据 ID 查询套餐
     *
     * @param id
     * @return
     */
    @Select("select `category_id`, `category`.`name`, `description`, `setmeal`.`id`, `image`, `setmeal`.`name`, `price`, `setmeal`.`status`, `setmeal`.`update_time` " +
            " from `setmeal` left outer join `category` on `setmeal`.`category_id` = `category`.`id`" +
            " where `setmeal`.`id` = #{id}")
    SetmealVO get(Long id);

    /**
     * 修改套餐
     *
     * @param setmeal
     */
    @Autofill(OperationType.UPDATE)
    void update(Setmeal setmeal);
}
