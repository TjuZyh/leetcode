package com.leetcode.DMSXL.binaryTree;

import com.leetcode.TreeNode;

/**
 * @Author zyh
 * @Date 2023/1/15 16:36
 * @Version 1.0
 */
/*
* 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先
*   输入：root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
*   输出：3
* */
public class LowestCommonAncestor_236 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //递归终止条件：1. 遇空返回空 2. 如果当前节点与p/q相等，则找到p/q，直接返回，证明已经找到
        if(root == null || root == p || root == q) return root;

        //后序遍历
        TreeNode left = lowestCommonAncestor(root.left, p ,q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        //1. 没找到p/q，则返回null
        if(left == null && right == null) return null;
        //2. 找到其中一个节点，则返回不空的那个
        if(left == null) return right;
        //3. 找到其中一个节点，则返回不空的那个
        if(right == null) return left;
        //4. 找到两个节点(left != null && right != null)，返回公共祖先root
        return root;
    }
}
