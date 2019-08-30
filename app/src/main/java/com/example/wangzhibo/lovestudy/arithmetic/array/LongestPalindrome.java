package com.example.wangzhibo.lovestudy.arithmetic.array;

/**
 * Created by samwangzhibo on 2019-08-23.
 */
public class LongestPalindrome {
  public static void main(String[] args) {
    String testStr = "asfdssadfasfadfs";
    System.out.println(longestPalindrome(testStr));
  }

  public static int longestPalindrome(String str) {
    int longestLength = 0;
    for (int i = 0; i < str.length(); i++) {
      longestLength = Math.max(longestLength, Math.max(isPalindrome(str, i, i), isPalindrome(str, i, i + 1)));
    }
    return longestLength;
  }

  private static int isPalindrome(String str, int start, int end) {
    int longestLength = start == end ? -1 : 0;
    String palindromeStr = "";
    while (start >= 0 && end < str.length() && str.charAt(start) == str.charAt(end)) {
      longestLength += 2;
      palindromeStr = str.substring(start, end+1);
      start--;
      end++;
    }
    System.out.println(palindromeStr);
    return longestLength;
  }

}
