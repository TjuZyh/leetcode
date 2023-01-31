package com.leetcode.DMSXL.binaryTree;

import com.leetcode.TreeNode;

/**
 * @Author zyh
 * @Date 2023/1/15 21:48
 * @Version 1.0
 */
/*
* 给定二叉搜索树（BST）的根节点 root 和要插入树中的值 value ，将值插入二叉搜索树
*   输入：root = [4,2,7,1,3], val = 5
*   输出：[4,2,7,1,3,5]
* */
public class InsertIntoBST_701 {
    /*
    * 迭代法，利用性质，遍历符合的位置插入即可
    * */
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null) {
            return new TreeNode(val);
        }
        TreeNode node = root;
        while (node != null) {
            if(val < node.val) {
                if(node.left == null) {
                    node.left = new TreeNode(val);
                    break;
                }else {
                    node = node.left;
                }
            } else {
                if(node.right == null) {
                    node.right = new TreeNode(val);
                    break;
                } else {
                    node = node.right;
                }
            }
        }
        return root;
    }

    /*
    * 递归方式
    * */
    public TreeNode insertIntoBST2(TreeNode root, int val) {
        if(root == null) return new TreeNode(val);

        if(root.val < val) {
            return insertIntoBST(root.right, val);
        }else if(root.val > val) {
            return insertIntoBST(root.left, val);
        }
        return root;
    }
}
