package com.example.wangzhibo.lovestudy.arithmetic.array;

/**
 *
 * 在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * Created by samwangzhibo on 2019/3/21.
 */
public class LeetCode1 {
    public static void main(String[] args) {
        int[][] nums = {{1,4,7},
                    {2, 6, 9},
                    {3, 8, 11}};
        boolean isFinded = findDesNum(nums, 2);
        System.out.println("find it ? " + isFinded);
    }

    private static boolean findDesNum(int[][] sourceNums, int desNum) {
        int i = 0; //当前行号,默认第一行
        int j = sourceNums[0].length - 1; //当前列

        //如果目标值 > 当前值

        return false;
    }
}
