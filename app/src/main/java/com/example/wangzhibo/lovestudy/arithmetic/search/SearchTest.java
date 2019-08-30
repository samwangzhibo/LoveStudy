package com.example.wangzhibo.lovestudy.arithmetic.search;

/**
 * Created by samwangzhibo on 2019-08-26.
 */
public class SearchTest {
  public static void main(String[] args) {
    int[] nums = new int[]{1, 4, 5, 7, 12, 56};
    int target = 14;
    int low = 0, high = nums.length - 1;
    while (low < high) {
      int mid = (low + high) / 2;
      if (nums[mid] == target) {
        System.out.println("find it! low = " + low + ", high = " + high);
        break;
      } else if (nums[mid] < target) {
        low = mid;
      }else {
        high = mid;
      }
    }
  }
}
