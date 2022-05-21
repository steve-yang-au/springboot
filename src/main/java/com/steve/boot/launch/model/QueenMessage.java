package com.steve.boot.launch.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class QueenMessage implements Serializable {

    private String title;

    private String content;

}