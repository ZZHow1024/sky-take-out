package com.sky.config;

import com.sky.properties.AliOssProperties;
import com.sky.utils.AliOssUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author ZZHow
 * @date 2024/8/20
 */
@Slf4j
@Configuration
public class OssConfiguration {

    @Bean
    @ConditionalOnMissingBean
    public AliOssUtil aliOssUtil(AliOssProperties aliOssProperties) {
        log.info("开始创建阿里云文件上传工具类对象，aliOssProperties = {}", aliOssProperties);

        if ("".equals(aliOssProperties.getEndpoint())) {
            log.info("未配置阿里云 OSS 服务，停止创建");
            return null;
        } else {
            log.info("阿里云文件上传工具类对象创建成功");
            return new AliOssUtil(aliOssProperties.getEndpoint(),
                    aliOssProperties.getAccessKeyId(),
                    aliOssProperties.getAccessKeySecret(),
                    aliOssProperties.getBucketName());
        }
    }
}
