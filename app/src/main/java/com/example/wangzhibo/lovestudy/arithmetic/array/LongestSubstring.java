package com.example.wangzhibo.lovestudy.arithmetic.array;

import java.util.HashSet;

//给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
//
// 示例 1:
//
// 输入: "abcabcbb"
//输出: 3
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
//
//
// 示例 2:
//
// 输入: "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
//
//
// 示例 3:
//
// 输入: "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
//
//
public class LongestSubstring {
  public static void main(String[] args) {
    String testStr = "pwwkew";
    System.out.println(lengthOfLongestSubstring(testStr));
  }
  public static int lengthOfLongestSubstring(String s) {
    int longestLength = 0;
    int left = 0, right = 0;
    HashSet<Character> subStringChars = new HashSet<>();
    // 递进条件
    while (right < s.length() && left < s.length()){
      Character rightChar = s.charAt(right);
      if (!subStringChars.contains(rightChar)){
        subStringChars.add(rightChar);
        System.out.println("add char " + rightChar);
        longestLength = Math.max(longestLength, subStringChars.size());
        right++;
      }else {
        Character leftChar = s.charAt(left);
        subStringChars.remove(leftChar);
        System.out.println("remove char " + leftChar);
        left++;
      }
    }
    return longestLength;
  }
}
