package com.example.wangzhibo.lovestudy.jvm.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * Created by samwangzhibo on 2019/3/8.
 */

public class AnnotationTest {
    @Path("/main")
    public static void main(String[] args) throws NoSuchMethodException {
        // 从源码中得知，设置这个值，可以把生成的代理类，输出出来。
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        //Method对象 里面有 Map<Class<? extends Annotation>, Annotation>
        Method method = AnnotationTest.class.getMethod("fetch");
        Path path = method.getAnnotation(Path.class);
        Annotation[] annotations = method.getAnnotations();
        System.out.println(path.value());
    }

    @Path(value="/aaa")
    public void fetch(){

    }
}
