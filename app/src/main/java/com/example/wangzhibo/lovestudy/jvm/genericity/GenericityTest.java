package com.example.wangzhibo.lovestudy.jvm.genericity;

import java.util.ArrayList;
import java.util.List;

/**
 * 这是泛型的测试类
 * 泛型包括上下界
 *
 * 1.<? super Integer> 包涵Integer和Integer的父类
 * 2.
 *
 * Created by samwangzhibo on 2019/2/27.
 */

public class GenericityTest<T> {
    T obj;

    public static void main(String[] args) {
        //报错 String[]数组不能转化为List<Object>
//        List<Object> objects = new String[]{};

        Object[] objects = new String[]{};
        // 整型也不报错
//        objects[1] = 1;

//        Object[] genericitys = new ArrayList<Object>();

        //报错 Integer不能转化为Number List
        List<? super Number> numbers = new ArrayList<>();

        //不能直接实例化 无限制边界符
//        List<?> numbers = new ArrayList<>();

        //报错
//        List<? super Number> numbers = new ArrayList<Integer>();

//        List<? extends Number> numbers = new ArrayList<>();

        // Number是Integer的父类 所以是上界
//        List<? super Integer> numbers = new ArrayList<Number>();

        //不行 必须通过上下界
//        List<Number> numberss = new ArrayList<Object>();

        List<? extends Number> objects1 = new ArrayList<Integer>();
        for (Number obj : objects1){
            obj.doubleValue();
        }

        //报错
        numbers.add(1);
        numbers.add(1.1);

        //报错
//        List<? extends Object> objectss = new ArrayList<String>();
//        objectss.add(1);

        System.out.println(numbers.get(0));

        sumOfList(new ArrayList<Integer>());
    }

    <T> T poll(T element) {
        return element;
    }


    <T, K> T fetch(K k, T t){
        return t;
    }


    public static double sumOfList(List<? extends Number> list) {
        double s = 0.0;
        for (Number n : list)
            s += n.doubleValue();
        return s;
    }
}
