package com.github.demo.designPattern.proxy.my_dynamic_proxy;

import com.github.demo.designPattern.proxy.static_proxy.Cat;
import com.github.demo.designPattern.proxy.static_proxy.Runnable;
import com.squareup.javapoet.FieldSpec;
import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.TypeSpec;

import javax.lang.model.element.Modifier;
import javax.tools.JavaCompiler;
import javax.tools.JavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

/**
 * @author 董感恩
 * @date 2020-07-24 17:25
 * @desc 动态生成LogProxy, 实现Runnable接口
 */
public class SimpleProxy {

    public static String projectPath = "/Users/apple/Documents/workspace/github/java/src/main/java";

    public static Object newProxyInstance(Object target) throws Exception {
        // 1. 生成.class文件
        TypeSpec.Builder typeSpecBuilder = TypeSpec.classBuilder("LogProxy")
                .addSuperinterface(Runnable.class);
        FieldSpec fieldSpec = FieldSpec.builder(Runnable.class, "runnable", Modifier.PRIVATE).build();
        typeSpecBuilder.addField(fieldSpec);
        MethodSpec constructorMethodSpec = MethodSpec.constructorBuilder()
                .addModifiers(Modifier.PUBLIC)
                .addParameter(Runnable.class, "runnable")
                .addStatement("this.runnable = runnable")
                .build();
        typeSpecBuilder.addMethod(constructorMethodSpec);
        Method[] methods = Runnable.class.getDeclaredMethods();
        for (Method method : methods) {
            MethodSpec methodSpec = MethodSpec.methodBuilder(method.getName())
                    .addModifiers(Modifier.PUBLIC)
                    .addAnnotation(Override.class)
                    .returns(method.getReturnType())
                    .addStatement("$T.out.println(\"日志记录开始\")", System.class)
                    .addCode("\n")
                    .addStatement("this.runnable." + method.getName() + "()")
                    .addCode("\n")
                    .addStatement("$T.out.println(\"日志记录结束\")", System.class)
                    .build();
            typeSpecBuilder.addMethod(methodSpec);
        }
        String packageName = "com.github.demo.designPattern.proxy.my_dynamic_proxy";
        JavaFile javaFile = JavaFile.builder(packageName, typeSpecBuilder.build()).build();
        javaFile.writeTo(new File(projectPath));

        //2.编译代理类
        JavaCompiler javaCompiler = ToolProvider.getSystemJavaCompiler();
        StandardJavaFileManager fileManager = javaCompiler.getStandardFileManager(null, null, null);
        File file = new File(projectPath + "/com/github/demo/designPattern/proxy/my_dynamic_proxy/LogProxy.java");
        Iterable<? extends JavaFileObject> iterable = fileManager.getJavaFileObjects(file);
        javax.tools.JavaCompiler.CompilationTask task = javaCompiler.getTask(null, fileManager, null, null, null, iterable);
        task.call();
        fileManager.close();

        //3.加载并调用代理类
        URL[] urls = new URL[] {new URL("file:/" + projectPath)};
        URLClassLoader classLoader = new URLClassLoader(urls);
        Class clazz = classLoader.loadClass(packageName + "." + "LogProxy");
        Constructor constructor = clazz.getConstructor(Runnable.class);
        Runnable runnable = (Runnable) constructor.newInstance(target);
        return runnable;
    }

    public static void main(String[] args) throws Exception {
        Runnable runnable = (Runnable) SimpleProxy.newProxyInstance(new Cat());
        runnable.run();
    }
}
