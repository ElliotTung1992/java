package com.github.demo.java.reflect.demo;

public class Student {

    public static void main(String[] args) {
        System.out.println("main方法执行了....");
    }

    //-----------------------------

    public String name;
    private Integer age;
    protected Boolean sex;
    Character ch;
    public Long distance;

    //-----------------------------

    //默认的构造函数
    Student(Character ch){
        System.out.println("默认的构造函数 ch:" + ch);
    }

    //公开 无参的构造函数
    public Student(){
        System.out.println("公用 无参的够着函数");
    }

    //公开 有一个参数的构造函数
    public Student(String name){
        System.out.println("公开 有一个参数的构造函数 name:" + name);
    }

    //公开 有两个参数的构造函数
    public Student(String name, Integer age){
        System.out.println("公开 有两个参数的构造函数 name:" + name + " age: " + age);
    }

    //受保护的构造函数
    protected Student(Boolean b){
        System.out.println("受保护的构造函数 b:" + b);
    }

    //私有的构造函数
    private Student(Integer age){
        System.out.println("私有的构造函数 age:" + age);
    }

    //-----------------------------

    public void show1(String name){
        System.out.println("公开的方法 name:" + name);
    }

    protected void show2(){
        System.out.println("受保护的方法");
    }

    void show3(){
        System.out.println("默认的方法");
    }

    private void show4(Integer age){
        System.out.println("私有的方法 age:" + age);
    }

    //-----------------------------


    public Character getCh() {
        return ch;
    }

    public void setCh(Character ch) {
        this.ch = ch;
    }

    public Boolean getSex() {
        return sex;
    }

    public void setSex(Boolean sex) {
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Long getDistance() {
        return distance;
    }

    public void setDistance(Long distance) {
        this.distance = distance;
    }
}
