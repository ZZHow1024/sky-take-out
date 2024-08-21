package com.sky.utils;

import io.minio.MinioClient;
import io.minio.PutObjectArgs;
import io.minio.errors.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.multipart.MultipartFile;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

/**
 * @author ZZHow
 * @date 2024/8/21
 */
@Data
@Slf4j
@AllArgsConstructor
public class MinIOUtil {

    private String endpoint;
    private String accessKeyId;
    private String accessKeySecret;
    private String bucketName;

    public String upload(MultipartFile file, String fileName) throws Exception {
        // 创建 MinioClient 实例
        MinioClient minioClient = MinioClient.builder()
                .endpoint(endpoint)
                .credentials(accessKeyId, accessKeySecret)
                .build();

        PutObjectArgs putObjectArgs = null;
        try {
            putObjectArgs = PutObjectArgs.builder()
                    .contentType(file.getContentType())
                    .stream(file.getInputStream(), file.getSize(), -1)
                    .bucket(bucketName)
                    .object(fileName)
                    .build();

            minioClient.putObject(putObjectArgs);
        } catch (ServerException | InsufficientDataException | ErrorResponseException |
                 NoSuchAlgorithmException | InvalidKeyException | InvalidResponseException | XmlParserException |
                 InternalException e) {
            log.error("MinIO 工具错误：{}", e.getMessage());
        } finally {
            minioClient.close();
        }

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder
                .append(endpoint)
                .append("/")
                .append(bucketName)
                .append("/")
                .append(fileName);
        log.info("文件上传到:{}", stringBuilder);

        return stringBuilder.toString();
    }
}
