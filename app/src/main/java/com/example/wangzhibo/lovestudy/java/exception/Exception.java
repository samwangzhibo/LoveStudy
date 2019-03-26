package com.example.wangzhibo.lovestudy.java.exception;

/**
 * 异常测试
 * 1.Error 属于系统的 比如系统级的JVM暂停
 * Created by samwangzhibo on 2019/3/22.
 */

public class Exception {

    static class ClickListener{
        void click() throws CusRuntimeException{
            System.out.println("click");
        }
        void doubleClick() throws ClassNotFoundException{
            System.out.println("doubleClick");
        }
    }

    public static void main(String[] args) {
        ClickListener clickListener = new ClickListener();
        //运行时异常不用手动的try catch
        clickListener.click();
        try {
            //类型转换是受检异常 需要手动的try catch 或者抛出去
            clickListener.doubleClick();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
