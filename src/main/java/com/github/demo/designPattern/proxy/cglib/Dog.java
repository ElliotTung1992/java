package com.github.demo.designPattern.proxy.cglib;

/**
 * @author 董感恩
 * @date 2020-07-28 14:04
 * @desc
 */
public class Dog {

    private String name;

    Dog(){

    }

    Dog(String name){
        this.name = name;
    }

    public void run(){
        System.out.println("dog is running");
    }

    public void eat(){
        System.out.println("dog is eating");
    }

    public String takeFrisbee(String frisbee){
        return "飞盘";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
