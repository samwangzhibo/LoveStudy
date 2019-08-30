package com.example.wangzhibo.lovestudy.arithmetic.linkedList;

/**
 * Created by samwangzhibo on 2019-08-23.
 */
public class Leetcode2 {
  public static void main(String[] args) {
    ListNode l1 = new ListNode(1);
    l1.next = new ListNode(2);
    l1.next.next = new ListNode(3);

    ListNode l2 = new ListNode(1);
    l2.next = new ListNode(2);
    l2.next.next = new ListNode(3);

    ListNode sumLt= addTwoNumbers(l1, l2);
    while (sumLt != null) {
      System.out.println(sumLt.val);
      sumLt = sumLt.next;
    }
  }

  public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode newNode = null;
    ListNode l3 = null;
    boolean isUpgrade = false;
    while (l1 != null || l2 != null || isUpgrade) {
      int l1Vaule = l1 != null ? l1.val : 0;
      int l2Vaule = l2 != null ? l2.val : 0;
      int sum = l1Vaule + l2Vaule + (isUpgrade ? 1 : 0);
      if (sum >= 10) {
        isUpgrade = true;
        sum -= 10;
      }
      if (newNode == null) {
        l3 = new ListNode(sum);
        newNode = l3;
      }else {
        l3.next = new ListNode(sum);
        l3 = l3.next;
      }
      l1 = l1.next;
      l2 = l2.next;
    }
    return newNode;
  }
}
