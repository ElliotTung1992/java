package com.github.demo.designPattern.strategy;

/**
 * @author 董感恩
 * @date 2020-05-09 17:54
 * @desc 开小火车去旅行
 */
@TravelInterface(value = "train")
public class TrainTravel implements TravelStrategy{

    @Override
    public String travel() {
        return "开小火车去旅行";
    }
}
