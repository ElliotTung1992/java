package com.github.demo.designPattern.template;

/**
 * @author 董感恩
 * @date 2020-07-22 17:15
 * @desc 数据库数据操作类型
 */
public abstract class DataOperation {

    abstract void insert();

    abstract void delete();

    abstract void update();

    //操作数据
    public final void operation(String operationType){
        switch (operationType){
            case "insert":
                insert();
                break;
            case "delete":
                delete();
                break;
            case "update":
                update();
                break;
        }
    }
}
