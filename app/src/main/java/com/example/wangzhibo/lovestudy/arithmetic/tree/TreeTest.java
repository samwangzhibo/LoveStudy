package com.example.wangzhibo.lovestudy.arithmetic.tree;

import java.util.LinkedList;

/**
 * Created by samwangzhibo on 2019-08-21.
 */
public class TreeTest {
  public static void main(String[] args) {
    TreeNode rootNode = new TreeNode(1);
    rootNode.left = new TreeNode(2);
    rootNode.right = new TreeNode(3);
    rootNode.left.left = new TreeNode(4);
    System.out.println(getHeightNoRecursion(rootNode));
  }

  /**------------------- 树的高度 ----------------------------**/

  public int getHeight(TreeNode root) {
    if (root == null) {
      return 0;
    }
    return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
  }

  /**
   * 非递归
   * @param root
   * @return
   */
  public static int getHeightNoRecursion(TreeNode root) {
    //队列
    LinkedList<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    // 1.定义变量
    int depth = 0;

    // 2.递进条件
    while (!queue.isEmpty()){
      int width = queue.size();
      for(int i=0; i< width; i++){
        TreeNode node = queue.peek();
        if(node.left != null){
          queue.offer(node.left);
        }
        if(node.right != null){
          queue.offer(node.right);
        }
      }
      depth++;
    }
    return depth;
  }

  /** --------------完全二叉树-----------------
   *
   * 根据完全二叉树的定义，对完全二叉树按照从上到下、从左到右的层次遍历，应该满足一下两条要求：
   * ●某节点没有左孩子，则一定无右孩子
   * ●若某节点缺左或右孩子，则其所有后继一定无孩子
   * 若不满足上述任何一条，均不为完全二叉树。
   **/
  public static boolean isFullTree(TreeNode root){
    LinkedList<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    boolean isNextNoChildren = false;

    // 递进条件
    while (!queue.isEmpty()){
      TreeNode node = queue.peek();
      if (isNextNoChildren){
        if (node.left !=null || node.right != null){
          return false;
        }
      }
      // 如果没有左孩子 肯定不该有右孩子
      if (node.left == null && node.right != null){
        return false;
      }
      if (node.left == null || node.right == null){
        isNextNoChildren = true;
      }
      if (node.left != null) {
        queue.offer(node.left);
      }
      if (node.right != null) {
        queue.offer(node.right);
      }
    }
    return true;
  }




}

