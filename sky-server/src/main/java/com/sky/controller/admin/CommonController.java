package com.sky.controller.admin;

import com.sky.constant.MessageConstant;
import com.sky.result.Result;
import com.sky.utils.AliOssUtil;
import com.sky.utils.MinIOUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;

/**
 * 通用接口
 *
 * @author ZZHow
 * @date 2024/8/20
 */
@Slf4j
@RestController
@RequestMapping("/admin/common")
@Api(tags = "通用接口")
public class CommonController {
    @Autowired(required = false)
    private AliOssUtil aliOssUtil;

    @Autowired(required = false)
    private MinIOUtil minIOUtil;

    /**
     * 文件上传
     *
     * @param file
     * @return
     */
    @PostMapping("/upload")
    @ApiOperation("文件上传")
    public Result<String> upload(MultipartFile file) {
        log.info("文件上传：file = {}", file);

        // 获取原始文件名
        String originalFilename = file.getOriginalFilename();
        // 获取文件后缀（文件扩展名）
        String extension = originalFilename.substring(originalFilename.lastIndexOf('.'));
        // 构造新文件名称
        String newFilename = UUID.randomUUID() + extension;

        // 优先使用阿里云 OSS 进行文件上传，若为配置则使用 MinIO 进行文件上传
        if (this.aliOssUtil != null) {
            try {
                log.info("使用阿里云 OSS 进行文件上传");
                String filePath = aliOssUtil.upload(file.getBytes(), newFilename);
                return Result.success(filePath);
            } catch (IOException e) {
                log.error("阿里云 OSS 文件上传失败：{}", e.getMessage());
            }
        } else {
            try {
                log.info("使用 MinIO 进行文件上传");
                String filePath = minIOUtil.upload(file, newFilename);
                return Result.success(filePath);
            } catch (Exception e) {
                log.error("MinIO 文件上传失败：{}", e.getMessage());
            }
        }

        return Result.error(MessageConstant.UPLOAD_FAILED);
    }
}
