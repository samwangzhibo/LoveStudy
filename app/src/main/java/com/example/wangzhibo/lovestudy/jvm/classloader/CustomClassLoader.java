package com.example.wangzhibo.lovestudy.jvm.classloader;

/**
 * 类加载器
 * 双亲委派 先从查找类是否已经被加载  如果没有则向父类询问 类是否加载
 *
 * Created by samwangzhibo on 2019/3/19.
 */

public class CustomClassLoader extends ClassLoader {
    CustomClassLoader(){
        super();
    }

    @Override
    protected Class<?> loadClass(String name, boolean resolve) throws ClassNotFoundException {
        return super.loadClass(name, resolve);
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
//        defineClass(String name, byte[] b, int off, int len,
//        ProtectionDomain protectionDomain, ProtectionDomain protectionDomain)
        return super.findClass(name);
    }
}
