package com.steve.boot.launch.model;

import lombok.Data;

import javax.validation.constraints.Min;

@Data
public class Father {
    private String name;
    @Min(21)
    private int age;
}
/**
 * more validation annotations to use:
 * @Size
 * @Patten
 * @Length
 * @Email
 * @NotNull
 * @Max
 * @Min
 */