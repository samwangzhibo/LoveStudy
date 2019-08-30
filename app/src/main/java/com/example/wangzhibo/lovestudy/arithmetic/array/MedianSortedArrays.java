package com.example.wangzhibo.lovestudy.arithmetic.array;

//给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
//
// 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
//
// 你可以假设 nums1 和 nums2 不会同时为空。
//
// 示例 1:
//
// nums1 = [1, 3]
//nums2 = [2]
//
//则中位数是 2.0
//
//
// 示例 2:
//
// nums1 = [1, 2]
//nums2 = [3, 4]
//
//则中位数是 (2 + 3)/2 = 2.5
//
//

public class MedianSortedArrays {
  public static void main(String[] args) {
    int[] nums1 = {1, 3};
    int[] nums2 = {2};
    System.out.println(findMedianSortedArrays(nums1, nums2));
  }
  public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
      //计算最终中位数的位置
    int middleNum = 0;
    int totalLength = nums1.length+nums2.length;
    if (totalLength % 2 == 0){
        int[] nums = getNumForPosition(nums1, nums2, totalLength/2, totalLength/2 +1);
      middleNum = (nums[0] + nums[2]) / 2;
    }else {
      int middlePosition = (totalLength + 1) / 2; //第一个
      middleNum = getNumForPosition(nums1, nums2, middlePosition)[0];
    }
    return middleNum;
  }

  private static int[] getNumForPosition(int[] nums1, int[] nums2, int... middlePosition) {
    int[] resultNums= new int[10];
    int i = 0, j = 0;
    int currentNum;
    int index = 0;
    while (i < nums1.length || j < nums2.length){
      int num1 = nums1[Math.min(i, nums1.length-1)];
      int num2 = nums2[Math.min(j, nums2.length-1)];
      if (num1 <= num2){
        i++;
      }else {
        j++;
      }
      index++;

      if (index == middlePosition[0]){
        resultNums[0] = Math.min(num1, num2);
      }
      if (middlePosition.length == 2 && index == middlePosition[1]){
        resultNums[1] = Math.min(num1, num2);
      }
    }
    return resultNums;
  }


}
