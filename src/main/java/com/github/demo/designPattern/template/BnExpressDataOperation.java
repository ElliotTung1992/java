package com.github.demo.designPattern.template;

/**
 * @author 董感恩
 * @date 2020-07-22 17:18
 * @desc
 */
public class BnExpressDataOperation extends DataOperation{

    @Override
    void insert() {
        System.out.println("新增操作");
    }

    @Override
    void delete() {
        System.out.println("删除操作");
    }

    @Override
    void update() {
        System.out.println("修改操作");
    }
}
