package com.github.demo.java5.annotation.Part2;


import java.lang.annotation.*;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class Part2 {

    public static void main(String[] args) throws Exception {
        String tableSql = createTableSql("com.github.demo.java5.annotation.Part2.People");
        System.out.println(tableSql);
    }

    public static String createTableSql(String className) throws Exception {
        Class<?> clazz = Class.forName(className);
        TableName tableName = clazz.getAnnotation(TableName.class);
        //是否使用TableName注解
        if(tableName == null){
            return null;
        }
        //判断tableName合法性
        String _tableName = tableName.name();
        if (_tableName.length() < 1){
            _tableName = clazz.getName().toUpperCase();
        }
        //获取类的所有字段
        List<String> columnDefs = new ArrayList<String>();
        Field[] fields = clazz.getDeclaredFields();
        for (Field field:fields) {
            Annotation[] annotations = field.getDeclaredAnnotations();
            if(annotations == null || annotations.length < 1){
                continue;
            }
            Annotation annotation = annotations[0];
            if(annotation instanceof SqlString){
                SqlString sqlString = (SqlString) annotation;
                String fieldName = sqlString.name();
                if(fieldName.length() < 1){
                    fieldName = field.getName();
                }
                int value = sqlString.value();
                columnDefs.add(fieldName + " VARCHAR(" + value + ")" + getConstraints(sqlString.constraints()));
            }
            if (annotation instanceof SqlInteger){
                SqlInteger sqlInteger = (SqlInteger) annotation;
                String fieldName = sqlInteger.name();
                if(fieldName.length() < 1){
                    fieldName = field.getName();
                }
                columnDefs.add(fieldName + " INT" + getConstraints(sqlInteger.constraints()));
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(" create table " + _tableName + "(");
        for (String s:columnDefs) {
            stringBuilder.append("\n " + s + ",");
        }
        String tableCreate = stringBuilder.substring(
                0, stringBuilder.length() - 1) + ");";
        return tableCreate;
    }

    //字段约束
    private static String getConstraints(Constraints constraints) {
        String sss = "";
        if(constraints.primaryKey()){
            sss += " primary key ";
        }
        if(!constraints.allowNull()){
            sss += " not null ";
        }
        if(constraints.unipue()){
            sss += " unique ";
        }
        return sss;
    }
}

/**
 * 表名注解
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface TableName {
    String name() default "";
}

/**
 * String字段类型注解
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@interface SqlString {
    String name() default "";
    int value() default 255;
    Constraints constraints() default @Constraints;
}

/**
 * Integer字段类型注解
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@interface SqlInteger {
    String name() default "";
    Constraints constraints() default @Constraints;
}

/**
 * 字段约束注解
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@interface Constraints {
    boolean primaryKey() default false;
    boolean allowNull() default false;
    boolean unipue() default false;
}

/**
 * people对象
 */
@TableName(name = "People")
class People{

    @SqlString(name = "id", value = 20, constraints=@Constraints(primaryKey = true, unipue = true))
    private String id;

    @SqlString(name = "name", constraints = @Constraints(allowNull = true))
    private String name;

    @SqlInteger(name = "age", constraints = @Constraints(allowNull = true))
    private Integer age;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
}

