package com.example.wangzhibo.lovestudy.codeinterview;

/**
 * 反转链表
 * Created by samwangzhibo on 2019/1/20.
 */

public class LinkedListTest {
    public static void main(String[] args) {
        Node head = new Node(1);
        Node curNode = head;
        for (int i=0; i < 5; i++){
            curNode.next = new Node(i + 2);
            curNode = curNode.next;
        }

        Node nowPrintNode = reverseList(head);
        printList(nowPrintNode);
    }

    private static void printList(Node nowPrintNode) {
        while (nowPrintNode != null){
            System.out.println(nowPrintNode.num);
            nowPrintNode = nowPrintNode.next;
        }
    }

    private static Node reverseList(Node head) {
        Node pre = null;
        Node now = head;
        Node next;
        while(now != null){
            //获取下一个node
            next = now.next;
            now.next = pre;

            pre = now;
            now = next;
        }
        return pre;
    }

    public static class Node{
        int num;
        Node next;
        Node(int num) {
            this.num = num;
        }
    }
}
