package com.example.nowcodernormal;

/**
 * 二叉树最大路径和
 *
 * 题目描述
 * 给定一个二叉树，请计算节点值之和最大的路径的节点值之和是多少。
 * 这个路径的开始节点和结束节点可以是二叉树中的任意节点
 */
public class NC6 {

    public int res = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        getMax(root);
        return res;
    }

    public int getMax(TreeNode root){
        if(root == null) {
            return 0;
        }
        int leftMax = Math.max(0,getMax(root.left));
        int rightMax = Math.max(0,getMax(root.right));
        res = Math.max(res,Math.max(root.val+Math.max(leftMax,rightMax),root.val+leftMax+rightMax));
        return Math.max(leftMax,rightMax) + root.val;
    }

    class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
    }
}
