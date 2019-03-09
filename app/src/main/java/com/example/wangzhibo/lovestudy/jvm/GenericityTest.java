package com.example.wangzhibo.lovestudy.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * 这是泛型的测试类
 * 泛型包括上下界
 * Created by samwangzhibo on 2019/2/27.
 */

public class GenericityTest {
    public static void main(String[] args) {
        //报错 String[]数组不能转化为List<Object>
//        List<Object> objects = new String[]{};

        //报错 Integer不能转化为Number List
//        List<Number> numbers = new ArrayList<Integer>();

        //报错
//        List<? super Number> numbers = new ArrayList<Integer>();
        // Number是Integer的父类 所以是上界
        List<? super Integer> numbers = new ArrayList<Number>();
        //报错
//        numbers.add(1.1);

        //报错
//        List<Object> objects = new ArrayList<String>();

    }
}
