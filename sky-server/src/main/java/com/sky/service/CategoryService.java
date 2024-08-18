package com.sky.service;

import com.sky.dto.CategoryDTO;
import com.sky.dto.CategoryPageQueryDTO;
import com.sky.result.PageResult;

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
}
