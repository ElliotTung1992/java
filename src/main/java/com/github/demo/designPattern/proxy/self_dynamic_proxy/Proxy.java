package com.github.demo.designPattern.proxy.self_dynamic_proxy;

import com.github.demo.designPattern.proxy.simple_demo.Bird;
import com.github.demo.designPattern.proxy.simple_demo.Flyable;
import com.squareup.javapoet.FieldSpec;
import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.TypeSpec;

import javax.lang.model.element.Modifier;
import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

/**
 * @author 董感恩
 * @date 2020-07-07 22:24
 * @desc 生成TimeProxy.java
 */
public class Proxy {

    public static String projectPath = "/Users/apple/Documents/workspace/github/java/src/main/java";

    public static Object newProxyInstance(Class inf, InvocationHandler handler) throws Exception {
        /*TypeSpec.Builder typeSpecBuilder = TypeSpec.classBuilder("TimeProxy")
                .addSuperinterface(inf);

        FieldSpec fieldSpec = FieldSpec.builder(inf, "flyable", Modifier.PRIVATE).build();
        typeSpecBuilder.addField(fieldSpec);

        MethodSpec constructorMethodSpec = MethodSpec.constructorBuilder()
                .addModifiers(Modifier.PUBLIC)
                .addParameter(inf, "flyable")
                .addStatement("this.flyable = flyable")
                .build();
        typeSpecBuilder.addMethod(constructorMethodSpec);

        Method[] methods = inf.getDeclaredMethods();
        for (Method method : methods) {
            MethodSpec methodSpec = MethodSpec.methodBuilder(method.getName())
                    .addModifiers(Modifier.PUBLIC)
                    .addAnnotation(Override.class)
                    .returns(method.getReturnType())
                    .addStatement("long start = $T.currentTimeMillis()", System.class)
                    .addCode("\n")
                    .addStatement("this.flyable." + method.getName() + "()")
                    .addCode("\n")
                    .addStatement("long end = $T.currentTimeMillis()", System.class)
                    .addStatement("$T.out.println(\"Fly Time =\" + (end - start))", System.class)
                    .build();
            typeSpecBuilder.addMethod(methodSpec);
        }

        JavaFile javaFile = JavaFile.builder("com.github.demo.designPattern.proxy.self_dynamic_proxy", typeSpecBuilder.build()).build();
        // 为了看的更清楚，我将源码文件生成到桌面
        javaFile.writeTo(new File(projectPath));

        // 编译
        JavaCompiler.compile(new File(projectPath + "/com/github/demo/designPattern/proxy/self_dynamic_proxy/TimeProxy.java"));

        Proxy.newProxyInstance(Flyable.class);
        URL[] urls = new URL[] {new URL("file:/" + projectPath)};
        URLClassLoader classLoader = new URLClassLoader(urls);
        Class clazz = classLoader.loadClass("com.github.demo.designPattern.proxy.self_dynamic_proxy.TimeProxy");
        Constructor constructor = clazz.getConstructor(Flyable.class);
        Flyable flyable = (Flyable) constructor.newInstance(new Bird());
        flyable.fly();
        */

        TypeSpec.Builder typeSpecBuilder = TypeSpec.classBuilder("TimeProxy")
                .addModifiers(Modifier.PUBLIC)
                .addSuperinterface(inf);

        FieldSpec fieldSpec = FieldSpec.builder(InvocationHandler.class, "handler", Modifier.PRIVATE).build();
        typeSpecBuilder.addField(fieldSpec);

        MethodSpec constructorMethodSpec = MethodSpec.constructorBuilder()
                .addModifiers(Modifier.PUBLIC)
                .addParameter(InvocationHandler.class, "handler")
                .addStatement("this.handler = handler")
                .build();

        typeSpecBuilder.addMethod(constructorMethodSpec);

        Method[] methods = inf.getDeclaredMethods();
        for (Method method : methods) {
            MethodSpec methodSpec = MethodSpec.methodBuilder(method.getName())
                    .addModifiers(Modifier.PUBLIC)
                    .addAnnotation(Override.class)
                    .returns(method.getReturnType())
                    .addCode("try {\n")
                    .addStatement("\t$T method = " + inf.getName() + ".class.getMethod(\"" + method.getName() + "\")", Method.class)
                    // 为了简单起见，这里参数直接写死为空
                    .addStatement("\tthis.handler.invoke(this, method, null)")
                    .addCode("} catch(Exception e) {\n")
                    .addCode("\te.printStackTrace();\n")
                    .addCode("}\n")
                    .build();
            typeSpecBuilder.addMethod(methodSpec);
        }

        JavaFile javaFile = JavaFile.builder("com.github.demo.designPattern.proxy.self_dynamic_proxy", typeSpecBuilder.build()).build();
        // 为了看的更清楚，我将源码文件生成到桌面
        javaFile.writeTo(new File(projectPath));

        // 编译
        JavaCompiler.compile(new File(projectPath + "/com/github/demo/designPattern/proxy/self_dynamic_proxy/TimeProxy.java"));

        URL[] urls = new URL[] {new URL("file:/" + projectPath)};
        URLClassLoader classLoader = new URLClassLoader(urls);
        Class clazz = classLoader.loadClass("com.github.demo.designPattern.proxy.self_dynamic_proxy.TimeProxy");
        Constructor constructor = clazz.getConstructor(InvocationHandler.class);
        Object obj = constructor.newInstance(handler);
        return obj;
    }

    public static void main(String[] args) throws Exception{
        Flyable b = (Flyable) Proxy.newProxyInstance(Flyable.class, new MyInvocationHandler(new Bird()));
        b.fly();
    }
}
