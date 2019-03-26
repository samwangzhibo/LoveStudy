package com.example.wangzhibo.lovestudy.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * 这是泛型的测试类
 * 泛型包括上下界
 * Created by samwangzhibo on 2019/2/27.
 */

public class GenericityTest {
    public static void main(String[] args) {
        //报错 String[]数组不能转化为List<Object>
//        List<Object> objects = new String[]{};
        Object[] objects = new String[]{};
        // 整型也不报错
        objects[1] = 1;

//        Object[] genericitys = new ArrayList<Object>();

        //报错 Integer不能转化为Number List
//        List<Number> numbers = new ArrayList<Integer>();

        //不能直接实例化 无限制边界符
//        List<?> numbers1 = new ArrayList<?>();

        //报错
//        List<? super Number> numbers = new ArrayList<Integer>();
        // Number是Integer的父类 所以是上界
        List<? super Integer> numbers = new ArrayList<Number>();

        //不行 必须通过上下界
//        List<Number> numberss = new ArrayList<Object>();
        //报错
//        numbers.add(1.1);

        //报错
//        List<Object> objects = new ArrayList<String>();

    }

    <T> T poll(T element) {
        return element;
    }
}
