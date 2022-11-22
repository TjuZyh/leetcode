package com.leetcode.DMSXL.binaryTree;

import com.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author zyh
 * @Date 2022/11/22 14:13
 * @Version 1.0
 */
/*
* 二叉树递归遍历
* */
public class TraversalBinaryTree {
    //前序遍历
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        preOrder(root, result);
        return result;
    }

    public void preOrder(TreeNode root, List<Integer> result) {
        if(root == null) return;
        result.add(root.val);
        preOrder(root.left, result);
        preOrder(root.right, result);
    }

    //中序遍历
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inOrder(root, result);
        return result;
    }

    public void inOrder(TreeNode root, List<Integer> result) {
        if(root == null) return;
        preOrder(root.left, result);
        result.add(root.val);
        preOrder(root.right, result);
    }

    //后序遍历
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        postOrder(root, result);
        return result;
    }

    public void postOrder(TreeNode root, List<Integer> result) {
        if(root == null) return;
        preOrder(root.left, result);
        preOrder(root.right, result);
        result.add(root.val);
    }
}
