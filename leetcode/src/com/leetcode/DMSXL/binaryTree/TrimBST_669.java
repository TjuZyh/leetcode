package com.leetcode.DMSXL.binaryTree;

import com.leetcode.TreeNode;

/**
 * @Author zyh
 * @Date 2023/1/31 21:03
 * @Version 1.0
 */
/*
* 给你二叉搜索树的根节点 root ，同时给定最小边界low 和最大边界 high。
*   通过修剪二叉搜索树，使得所有节点的值在[low, high]中
* 修剪树 不应该 改变保留在树中的元素的相对结构
 * */
public class TrimBST_669 {
    public TreeNode trimBST(TreeNode root, int low, int high) {
        //当前的root值在规定范围内
        if(root.val >= low && root.val <= high) {
            if(root.left != null) {
                root.left = trimBST(root.left, low, high);
            }
            if(root.right != null) {
                root.right = trimBST(root.right, low, high);
            }
            return root;
        }
        if(root.val < low) {
            if(root.right != null) {
                return trimBST(root.right, low, high);
            }else {
                return null;
            }
        }
        if(root.val > high) {
            if(root.left != null) {
                return trimBST(root.left, low, high);
            }else {
                return null;
            }
        }
        return root;
    }
}
