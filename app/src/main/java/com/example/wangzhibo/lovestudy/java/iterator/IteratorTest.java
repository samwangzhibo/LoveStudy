package com.example.wangzhibo.lovestudy.java.iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by samwangzhibo on 2019/3/22.
 */

public class IteratorTest {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>();
        list.add(0);
        for(int i=0; i<list.size() && i<5 ; i++) {
            list.add(i+1);
        }
        System.out.println(list);

        //语法糖 最后是Iterator
        for (int i : list){
            //ConcurrentModificationException
            list.add(1);
            System.out.println(i + "");
        }

        Iterator iterator = list.iterator();
        while(iterator.hasNext()) {
            int i = (int) iterator.next();
            System.out.println(i + "");
        }
    }
}
