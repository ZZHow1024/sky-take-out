package com.sky.service;

import com.sky.dto.DishDTO;

/**
 * @author ZZHow
 * @date 2024/8/21
 */
public interface DishService {

    /**
     * 新增菜品
     *
     * @param dishDTO
     */
    void saveWithFlavor(DishDTO dishDTO);
}
