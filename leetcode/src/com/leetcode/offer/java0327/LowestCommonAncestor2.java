package com.leetcode.offer.java0327;

import com.leetcode.TreeNode;

/*
* 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
* */
public class LowestCommonAncestor2 {
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor2(root.left , p , q);
        TreeNode right = lowestCommonAncestor2(root.right , p , q);
        if(left == null) return right;
        if(right == null) return left;
        return root;
    }
}
