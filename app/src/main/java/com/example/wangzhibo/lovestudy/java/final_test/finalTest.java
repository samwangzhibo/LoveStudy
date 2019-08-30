package com.example.wangzhibo.lovestudy.java.final_test;

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
        Entry entry = new Entry("aaa");
//        modifyEntry(entry);
        modifyEntryFinal(entry);
        System.out.println(entry.key);
    }

    private static void modifyEntry(Entry entry) {
        entry.key = "bbbb";
    }

    private static void modifyEntryFinal(final Entry entry) {
        entry.key = "bbbb";
    }
}
