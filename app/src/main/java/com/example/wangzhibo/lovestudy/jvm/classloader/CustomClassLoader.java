package com.example.wangzhibo.lovestudy.jvm.classloader;

/**
 * 类加载器
 * 双亲委派 先从查找类是否已经被加载（缓存查找）  如果没有则向父类询问 类是否加载（父类缓存）
 *
 * Created by samwangzhibo on 2019/3/19.
 */

public class CustomClassLoader extends ClassLoader {
    CustomClassLoader(){
        super();
    }

    /**
     * 双亲委派查询
     * @param name
     * @param resolve
     * @return
     * @throws ClassNotFoundException
     */
    @Override
    protected Class<?> loadClass(String name, boolean resolve) throws ClassNotFoundException {
        return super.loadClass(name, resolve);
    }

    /**
     * 主要重写方法
     * 方法中使用 {@link #defineClass(String, byte[], int, int)} 获取Class
     * @param name
     * @return
     * @throws ClassNotFoundException
     */
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
//        defineClass(String name, byte[] b, int off, int len)
        return super.findClass(name);
    }
}
