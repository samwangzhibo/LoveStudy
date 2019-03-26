package com.example.wangzhibo.lovestudy.java.enum_test;

/**
 * Created by samwangzhibo on 2019/3/21.
 */

public class EnumTest {
    public static void main(String[] args) {
        CustomEnum[] customEnums =CustomEnum.values();
        for (CustomEnum customEnum : customEnums){
            System.out.println(customEnum.getDescription() + " : " + customEnum.getInfo());
        }
    }
}
