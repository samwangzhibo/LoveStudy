package com.example.wangzhibo.lovestudy.arithmetic.array;

/**
 * 在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * Created by samwangzhibo on 2019/3/21.
 */
public class LeetCode1 {
  public static void main(String[] args) {
    int[][] nums = {{1, 4, 7},
        {2, 6, 9},
        {3, 8, 11}};
    System.out.println("isFindNums : " + isFindNums(nums, 2));
  }

  private static boolean isFindNums(int[][] nums, int target) {
    // 1.定变量
    int x = nums[0].length - 1;
    int y = 0;

    while (x >= 0 && y < nums.length) {
      if (nums[x][y] == target) {
        return true;
      } else if (nums[x][y] > target) {
        y++;
      } else {
        x--;
      }
    }
    return false;
  }

}
