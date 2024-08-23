package com.sky.controller.admin;

import com.sky.dto.SetmealDTO;
import com.sky.dto.SetmealPageQueryDTO;
import com.sky.result.PageResult;
import com.sky.result.Result;
import com.sky.service.SetmealService;
import com.sky.vo.SetmealVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author ZZHow
 * @date 2024/8/23
 */
@Slf4j
@RestController
@RequestMapping("/admin/setmeal")
@Api(tags = "套餐相关接口")
public class SetmealController {

    @Autowired
    private SetmealService setmealService;

    /**
     * 新增套餐
     *
     * @param setmealDTO
     * @return
     */
    @PostMapping
    @ApiOperation("新增套餐")
    public Result<String> save(@RequestBody SetmealDTO setmealDTO) {
        log.info("新增套餐：setmealDTO = {}", setmealDTO);

        setmealService.save(setmealDTO);

        return Result.success();
    }

    /**
     * 套餐分页查询
     *
     * @param setmealPageQueryDTO
     * @return
     */
    @GetMapping("/page")
    @ApiOperation("套餐分页查询")
    public Result<PageResult> page(SetmealPageQueryDTO setmealPageQueryDTO) {
        log.info("套餐分页查询：setmealPageQueryDTO = {}", setmealPageQueryDTO);

        PageResult pageResult = setmealService.page(setmealPageQueryDTO);

        return Result.success(pageResult);
    }

    /**
     * 批量删除套餐
     *
     * @param ids
     * @return
     */
    @DeleteMapping
    @ApiOperation("批量删除套餐")
    public Result<String> removeByIds(@RequestParam List<Long> ids) {
        log.info("批量删除套餐：ids = {}", ids);

        setmealService.removeByIds(ids);

        return Result.success();
    }

    /**
     * 根据 ID 查询套餐
     *
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    @ApiOperation("根据 ID 查询套餐")
    public Result<SetmealVO> get(@PathVariable Long id) {
        log.info("根据 ID 查询套餐：id = {}", id);

        SetmealVO setmealVO = setmealService.get(id);

        return Result.success(setmealVO);
    }

    /**
     * 修改套餐
     *
     * @param setmealDTO
     * @return
     */
    @PutMapping
    @ApiOperation("修改套餐")
    public Result<String> update(@RequestBody SetmealDTO setmealDTO) {
        log.info("修改套餐：setmealDTO = {}", setmealDTO);

        setmealService.update(setmealDTO);

        return Result.success();
    }

    /**
     * 起售停售套餐
     *
     * @param status
     * @return
     */
    @PostMapping("/status/{status}")
    @ApiOperation("起售停售套餐")
    public Result<String> startOrStop(@PathVariable Integer status, Long id) {
        log.info("起售停售套餐：status = {}", status);

        setmealService.startOrStop(status, id);

        return Result.success();
    }
}
