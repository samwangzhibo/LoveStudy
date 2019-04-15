package com.example.wangzhibo.lovestudy.arithmetic.array;

import java.util.LinkedList;

/**
 * Created by samwangzhibo on 2019/4/7.
 */

public class PingduoduoTest {
    public static void main(String[] args) {
        int[] nums = {1, 4, 7};
        // 1 + 4 * 2 + 7 * 2^2
//        System.out.println(Evaluate(nums, 2));


        TreeNode rootNode = new TreeNode(1);
        rootNode.left = new TreeNode(2);
        rootNode.right = new TreeNode(3);
        rootNode.left.left = new TreeNode(4);
        System.out.println(new Solution().getHeightNoRecursion(rootNode));
    }

    static int Evaluate(int[] a, int x) {
        int result = 0;
        int tempX = 1;
        for (int i = 0; i < a.length; i++) {
            int aNow = a[i]; //当前a的值
            result += aNow * tempX; // a[j]X^j
            tempX *= x; //tempX是x的次方
        }
        return result;
    }

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
   public static class Solution {

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
        public int getHeightNoRecursion(TreeNode root) {
            //队列
            LinkedList<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            int depth = 0;
            while (!queue.isEmpty()){

            }
            return depth;
        }
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int x) {
            val = x;
        }
    }

}
