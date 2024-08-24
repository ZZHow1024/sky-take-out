package com.sky.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author ZZHow
 * @date 2024/8/21
 */
@Data
@Component
@ConfigurationProperties(prefix = "sky.minio")
public class MinIOProperties {

    private String endpoint;
    private String accessKeyId;
    private String accessKeySecret;
    private String bucketName;

}
