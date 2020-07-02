package com.github.demo.designPattern.strategy;

/**
 * @author 董感恩
 * @date 2020-05-09 17:54
 * @desc 开小轮船去旅行
 */
@TravelInterface(value = "ship")
public class ShipTravel implements TravelStrategy{

    @Override
    public String travel() {
        return "开小轮船去旅行";
    }
}
