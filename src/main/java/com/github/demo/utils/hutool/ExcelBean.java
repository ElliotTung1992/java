package com.github.demo.utils.hutool;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author 董感恩
 * @date 2020-03-16 14:48
 * @desc
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ExcelBean {
    private String name;
    private int age;
    private double score;
    private boolean isPass;
    private Date examDate;
}
