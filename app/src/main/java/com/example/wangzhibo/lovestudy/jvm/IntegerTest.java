package com.example.wangzhibo.lovestudy.jvm;

import java.util.HashMap;

/**
 * 这是讲integer对象的==判断
 * System.out.println()的原理 就是创建一个和终端输出设备的文件流 out 然后调用封装的println()方法
 * Created by samwangzhibo on 2019/1/24.
 */

public class IntegerTest {
    public static void main(String[] args) {
        Integer a = new Integer(1);
        Integer b = new Integer(1);
        System.out.println("a==b : " + (a==b));
        System.out.println("a.equals(b) : " + a.equals(b));

        HashMap<Integer, Integer> nums = new HashMap<>();
        nums.put(a, a);
        nums.put(b, b);
        System.out.println(nums.size());
        /**
         * 第1步 FileDescriptor fd = FileDescriptor.out;
           第2步 FileOutputStream fdOut = new FileOutputStream(fd);
           第3步 BufferedOutputStream bufOut = new BufferedOutputStream(fdOut, 128);
           第4步 PrintStream ps = new PrintStream(bufout, true);
           第5步 setOut0(ps);
         */
        System.out.println(System.getProperty("java.home"));
    }
}
