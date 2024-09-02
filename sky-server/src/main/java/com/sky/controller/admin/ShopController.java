package com.sky.controller.admin;

import com.sky.result.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

/**
 * @author ZZHow
 * @date 2024/9/2
 */
@Slf4j
@RestController("adminShopController")
@RequestMapping("/admin/shop")
@Api(tags = "店铺相关接口")
public class ShopController {

    public static final String SET = "SHOP_STATUS";

    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 设置营业状态
     *
     * @param status
     * @return
     */
    @PutMapping("/{status}")
    @ApiOperation("设置营业状态")
    public Result<String> setStatus(@PathVariable Integer status) {
        log.info("设置营业状态：status = {}", status);

        redisTemplate.opsForValue().set(SET, status);

        return Result.success();
    }

    /**
     * 获取营业状态
     *
     * @return
     */
    @GetMapping("/status")
    @ApiOperation("获取营业状态")
    public Result<Integer> getStatus() {
        log.info("获取营业状态");

        Integer shopStatus = (Integer) redisTemplate.opsForValue().get(SET);

        return Result.success(shopStatus);
    }

}
