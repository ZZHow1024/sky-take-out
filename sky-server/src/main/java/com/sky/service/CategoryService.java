package com.sky.service;

import com.sky.dto.CategoryDTO;

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
}
