package com.github.demo.java5.introspector.part1;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Test1 {

    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException, NoSuchFieldException, IntrospectionException {
        //使用反射
        useReflect();
        //使用内省
        useIntrospector();
    }

    private static void useIntrospector() throws IntrospectionException, InvocationTargetException, IllegalAccessException {
        User user = new User();
        PropertyDescriptor pd = new PropertyDescriptor("name", User.class);
        //获取属性的set方法
        Method writeMethod = pd.getWriteMethod();
        writeMethod.invoke(user, "feng");
        //获取属性get方法
        Method readMethod = pd.getReadMethod();
        Object invoke = readMethod.invoke(user, null);
        System.out.println(invoke);

        //获取所有属性
        BeanInfo beanInfo = Introspector.getBeanInfo(User.class);
        PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
        for (PropertyDescriptor propertyDescriptor:propertyDescriptors) {

        }
    }

    private static void useReflect() throws NoSuchFieldException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, InstantiationException {
        Class<User> clazz = User.class;
        Constructor<User> constructor = clazz.getConstructor();
        User user = constructor.newInstance();
        Field field = clazz.getDeclaredField("name");
        field.setAccessible(true);
        field.set(user, "dong");
        String name = user.getName();
        System.out.println(name);
    }
}

class User{

    private String name;
    private Integer age;

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

    public User(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public User() {

    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
