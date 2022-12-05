package com.leetcode.DMSXL.binaryTree;

import com.leetcode.TreeNode;

/**
 * @Author zyh
 * @Date 2022/12/5 23:23
 * @Version 1.0
 */
/*
* 给你两棵二叉树 root 和 subRoot 。检验 root 中是否包含和 subRoot 具有相同结构和节点值的子树。
* 如果存在，返回 true ；否则，返回 false
* */
public class IsSubtree_572 {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        return DFS(root, subRoot);
    }

    public boolean DFS(TreeNode root, TreeNode subRoot) {
        if(root == null && subRoot != null) return false;
        return DFS(root.left, subRoot) || DFS(root.right, subRoot) ||check(root, subRoot);
    }

    public boolean check(TreeNode node, TreeNode subRoot) {
        if(node == null && subRoot == null) {
            return true;
        }
        if(node == null || subRoot == null) {
            return false;
        }
        if(node.val != subRoot.val) {
            return false;
        }
        return check(node.left, subRoot.left) && check(node.right, subRoot.right);
    }
}
