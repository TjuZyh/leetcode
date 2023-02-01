package com.leetcode.DMSXL.binaryTree;

import com.leetcode.TreeNode;

/**
 * @Author zyh
 * @Date 2023/2/1 09:58
 * @Version 1.0
 */
/*
* 给出二叉 搜索 树的根节点，该树的节点值各不相同，请你将其转换为累加树（Greater Sum Tree）
* */
public class ConvertBST_538 {
    /*
    * 反序中序遍历BST得到单调递减的有序数列
    *   反序中序遍历，记录节点之和，并更新
    * */
    private int sum = 0;
    public TreeNode convertBST(TreeNode root) {
        if(root != null) {
            convertBST(root.right);
            sum += root.val;
            root.val = sum;
            convertBST(root.left);
        }
        return root;
    }
}
