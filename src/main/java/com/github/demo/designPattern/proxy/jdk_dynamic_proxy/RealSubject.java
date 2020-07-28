package com.github.demo.designPattern.proxy.jdk_dynamic_proxy;

public class RealSubject implements Subject{

  @Override
  public void addSubject() {
    System.out.println("ReallySubject -> addSubject");
  }

  @Override
  public void getSubjectCount() {
    System.out.println("ReallySubject -> getSubjectCount");
  }
}
