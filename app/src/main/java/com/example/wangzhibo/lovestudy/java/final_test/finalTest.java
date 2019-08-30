package com.example.wangzhibo.lovestudy.java.final_test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 测试 final
 *
 *
 * Created by samwangzhibo on 2019/3/19.
 */

public class finalTest {
    public static void main(String[] args) {
      // 备注
      // rebase2
      // 备注 在test_rebase分支选择rebase current onto selected
        Entry entry = new Entry("aaa");
//        modifyEntry(entry);
        modifyEntryFinal(entry);
        int i = 1;
        new InvocationHandler(){

          @Override
          public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            return new Integer(i);
          }
        };
        System.out.println(entry.key);
    }

    private static void modifyEntry(Entry entry) {
        entry.key = "bbbb";
    }

    private static void modifyEntryFinal(final Entry entry) {
        entry.key = "bbbb";
    }
}
