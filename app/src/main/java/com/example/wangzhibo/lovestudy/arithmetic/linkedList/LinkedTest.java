package com.example.wangzhibo.lovestudy.arithmetic.linkedList;

/**
 * 1.链表判环
 * Created by samwangzhibo on 2019/4/11.
 */

public class LinkedTest {

    public static void main(String[] args) {
      LinkedNode rootNode = new LinkedNode();
      LinkedNode nodeA = new LinkedNode();
      LinkedNode nodeB = new LinkedNode();
      LinkedNode nodeC = new LinkedNode();
      rootNode.next = nodeA;
      nodeA.next = nodeB;
      nodeB.next = nodeC;
      nodeC.next = nodeA;
      hasCircle(rootNode);
    }

  private static boolean hasCircle(LinkedNode rootNode) {
    // 1.变量
    LinkedNode slower = rootNode, faster = rootNode;

    // 2.递进条件
    do {
      slower = slower.next;
      faster = faster.next.next;
      // 3.终止条件
      if (slower == faster){
        return true;
      }
    }while (true);
  }

}
