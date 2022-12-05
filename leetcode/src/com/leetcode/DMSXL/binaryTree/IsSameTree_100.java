package com.leetcode.DMSXL.binaryTree;

import com.leetcode.TreeNode;

/**
 * @Author zyh
 * @Date 2022/12/5 23:03
 * @Version 1.0
 */
/*
* 给你两棵二叉树的根节点 p 和 q ，编写一个函数来检验这两棵树是否相同
* */
public class IsSameTree_100 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        return DFS(p, q);
    }

    public boolean DFS(TreeNode p, TreeNode q) {
        if(p == null && q == null) return true;
        if(p == null || q == null) return false;
        if(p.val != q.val) return false;
        return DFS(p.left, q.left) && DFS(p.right, q.right);
    }
}
