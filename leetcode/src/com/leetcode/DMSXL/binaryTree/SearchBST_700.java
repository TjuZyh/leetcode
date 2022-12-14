package com.leetcode.DMSXL.binaryTree;

import com.leetcode.TreeNode;

/**
 * @Author zyh
 * @Date 2022/12/14 11:36
 * @Version 1.0
 */
/*
* 在 BST 中找到节点值等于 val 的节点。 返回以该节点为根的子树
*   输入：root = [4,2,7,1,3], val = 2
*   输出：[2,1,3]
* */
public class SearchBST_700 {
    /*
    * 递归
    * */
    public TreeNode searchBST(TreeNode root, int val) {
        if(root == null) {
            return null;
        }
        if(val > root.val) {
            return searchBST(root.right, val);
        }else if(val < root.val){
            return searchBST(root.left, val);
        }else {
            return root;
        }
    }

    /*
    * 迭代
    * */
    public TreeNode searchBST2(TreeNode root, int val) {
        while(root != null) {
            if(root.val == val) {
                return root;
            }
            root = val < root.val ? root.left : root.right;
        }
        return null;
    }

}
