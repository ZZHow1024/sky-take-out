package com.sky.config;

import com.sky.properties.MinIOProperties;
import com.sky.utils.MinIOUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author ZZHow
 * @date 2024/8/21
 */
@Slf4j
@Configuration
public class MinIOConfiguration {

    @Bean
    @ConditionalOnMissingBean
    public MinIOUtil minIOUtil(MinIOProperties minIOProperties) {
        log.info("开始创建 MinIO 文件上传工具类对象，minIOProperties = {}", minIOProperties);

        if ("".equals(minIOProperties.getEndpoint())) {
            log.info("未配置 MinIO 服务，停止创建");
            return null;
        } else {
            log.info("MinIO 文件上传工具类对象创建成功");
            return new MinIOUtil(minIOProperties.getEndpoint(),
                    minIOProperties.getAccessKeyId(),
                    minIOProperties.getAccessKeySecret(),
                    minIOProperties.getBucketName());
        }
    }
}
