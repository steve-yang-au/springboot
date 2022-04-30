package com.steve.boot.launch.model;

import com.steve.boot.launch.service.CommonPropertySourceFactory;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotEmpty;

@Data
@Component
@Validated
@ConfigurationProperties(prefix = "family")
@PropertySource(value = "classpath:otherConfig/family.yml", factory = CommonPropertySourceFactory.class)
public class Family {
    //@Value("${family.family-name}")
    @NotEmpty
    private String familyName;
    private Father father;
    private Mother mother;
    private Child child;
}
