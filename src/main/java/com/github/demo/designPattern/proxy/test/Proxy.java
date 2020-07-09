package com.github.demo.designPattern.proxy.test;

import com.github.demo.designPattern.proxy.dynamic_proxy.RealSubject;
import com.github.demo.designPattern.proxy.dynamic_proxy.Subject;
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
 * @date 2020-07-09 10:15
 * @desc 代理类
 */
public class Proxy {

    public static String projectPath = "/Users/apple/Documents/workspace/github/java/src/main/java";

    public static Object newPoxyInstance(Class interfaceClass, InvocationHandler invocationHandler) throws Exception {

        //1.动态生成代理类
        TypeSpec.Builder typeSpecBuilder = TypeSpec.classBuilder("ProxyRealSubject")
                .addModifiers(Modifier.PUBLIC)
                .addSuperinterface(interfaceClass);

        FieldSpec fieldSpec = FieldSpec.builder(InvocationHandler.class, "invocationHandler", Modifier.PRIVATE).build();
        typeSpecBuilder.addField(fieldSpec);

        MethodSpec constructorMethod = MethodSpec.constructorBuilder()
                .addModifiers(Modifier.PUBLIC)
                .addParameter(InvocationHandler.class, "invocationHandler")
                .addStatement("this.invocationHandler = invocationHandler")
                .build();
        typeSpecBuilder.addMethod(constructorMethod);

        Method[] methods = interfaceClass.getDeclaredMethods();
        for (Method method:methods) {
            MethodSpec methodSpec = MethodSpec.methodBuilder(method.getName())
                    .addModifiers(Modifier.PUBLIC)
                    .addAnnotation(Override.class)
                    .returns(method.getReturnType())
                    .addCode("try {\n")
                    .addStatement("\t$T method = " + interfaceClass.getName() + ".class.getMethod(\"" + method.getName() + "\")", Method.class)
                    // 为了简单起见，这里参数直接写死为空
                    .addStatement("\tthis.invocationHandler.invoke(this, method, null)")
                    .addCode("} catch(Exception e) {\n")
                    .addCode("\te.printStackTrace();\n")
                    .addCode("}\n")
                    .build();
            typeSpecBuilder.addMethod(methodSpec);
        }

        String packageName = "com.github.demo.designPattern.proxy.test";

        JavaFile javaFile = JavaFile.builder(packageName, typeSpecBuilder.build()).build();
        javaFile.writeTo(new File(projectPath));

        //2.编译代理类
        JavaCompiler javaCompiler = ToolProvider.getSystemJavaCompiler();
        StandardJavaFileManager fileManager = javaCompiler.getStandardFileManager(null, null, null);
        File file = new File(projectPath + "/com/github/demo/designPattern/proxy/test/ProxyRealSubject.java");
        Iterable<? extends JavaFileObject> iterable = fileManager.getJavaFileObjects(file);
        javax.tools.JavaCompiler.CompilationTask task = javaCompiler.getTask(null, fileManager, null, null, null, iterable);
        task.call();
        fileManager.close();

        //3.加载并调用代理类
        URL[] urls = new URL[] {new URL("file:/" + projectPath)};
        URLClassLoader classLoader = new URLClassLoader(urls);
        Class clazz = classLoader.loadClass(packageName + "." + "ProxyRealSubject");
        Constructor constructor = clazz.getConstructor(InvocationHandler.class);
        return constructor.newInstance(invocationHandler);
    }

    public static void main(String[] args) throws Exception {
        TimeInvocationHandler timeInvocationHandler = new TimeInvocationHandler(new RealSubject());
        Subject poxyInstance = (Subject) Proxy.newPoxyInstance(Subject.class, timeInvocationHandler);
        poxyInstance.addSubject();
        poxyInstance.getSubjectCount();

        String packageName = Subject.class.getPackageName();
        System.out.println(packageName);

    }
}
