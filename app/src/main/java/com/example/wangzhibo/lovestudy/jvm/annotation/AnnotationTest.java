package com.example.wangzhibo.lovestudy.jvm.annotation;

/**
 * Created by samwangzhibo on 2019/3/8.
 */

public class AnnotationTest {
    @Path("/main")
    public static void main(String[] args) throws NoSuchMethodException {
        // 从源码中得知，设置这个值，可以把生成的代理类，输出出来。
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        //Method对象 里面有 Map<Class<? extends Annotation>, Annotation>
        Path path = AnnotationTest.class.getMethod("fetch").getAnnotation(Path.class);
        System.out.println(path.value());
    }

    @Path(value="/aaa")
    public void fetch(){

    }
}
