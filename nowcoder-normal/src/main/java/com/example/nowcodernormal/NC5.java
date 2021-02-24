package com.example.nowcodernormal;

/**
 * 二叉树根节点到叶子节点的所有路径
 * <p>
 * 题目描述
 * 给定一个仅包含数字 0−9 的二叉树，每一条从根节点到叶子节点的路径都可以用一个数字表示。
 * 例如根节点到叶子节点的一条路径是1→2→3,那么这条路径就用 123 来代替。
 * 找出根节点到叶子节点的所有路径表示的数字之和
 */
public class NC5 {

    public int sumNumbers (TreeNode root) {
        if(root == null){
            return 0;
        }
        return sumNumbers(root, root.val);
    }

    private int sumNumbers(TreeNode root, int sum){
        if(root.left==null && root.right==null){
            return sum;
        }
        int result = 0;
        if(root.left!=null){
            result+=sumNumbers(root.left, sum*10+root.left.val);
        }
        if(root.right!=null){
            result+=sumNumbers(root.right, sum*10+root.right.val);
        }
        return result;
    }

    class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
    }
}
