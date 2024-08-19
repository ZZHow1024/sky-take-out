package com.sky.service;

import com.sky.dto.CategoryDTO;
import com.sky.dto.CategoryPageQueryDTO;
import com.sky.entity.Category;
import com.sky.result.PageResult;

import java.util.List;

/**
 * @author ZZHow
 * @date 2024/8/18
 */
public interface CategoryService {

    /**
     * 新增分类
     *
     * @param categoryDTO
     */
    void save(CategoryDTO categoryDTO);

    /**
     * 分类分页查询
     *
     * @param categoryPageQueryDTO
     * @return
     */
    PageResult pageQuery(CategoryPageQueryDTO categoryPageQueryDTO);

    /**
     * 启用禁用分类
     *
     * @param id
     * @param status
     */
    void startOrStop(Long id, Integer status);

    /**
     * 修改分类
     *
     * @param categoryDTO
     */
    void update(CategoryDTO categoryDTO);

    /**
     * 根据 ID 删除分类
     *
     * @param id
     */
    void remove(Long id);

    /**
     * 根据类型查询分类
     *
     * @param type
     * @return
     */
    List<Category> getByType(Integer type);
}
