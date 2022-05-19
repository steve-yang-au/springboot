package com.steve.boot.launch.model;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "minio")
public class MinIOProperties {
    private String endpoint;
    private String accessKey;
    private String secretKey;
}