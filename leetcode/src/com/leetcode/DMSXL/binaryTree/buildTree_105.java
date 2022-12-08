package com.leetcode.DMSXL.binaryTree;

import com.leetcode.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author zyh
 * @Date 2022/12/8 22:48
 * @Version 1.0
 */
/*
* 给定两个整数数组preorder 和 inorder，其中preorder 是二叉树的先序遍历， inorder是同一棵树的中序遍历，
*   请构造二叉树并返回其根节点。
* */
public class buildTree_105 {
    Map<Integer, Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return DFS(preorder, 0, preorder.length, inorder, 0, inorder.length);
    }

    /*
    * 注意区间是左闭右开
    * */
    public TreeNode DFS(int[] preorder, int preBegin, int preEnd, int[] inorder, int inBegin, int inEnd) {
        if(preBegin >= preEnd || inBegin >= inEnd) {
            return null;
        }
        int rootIndex = map.get(preorder[preBegin]);
        TreeNode root = new TreeNode(inorder[rootIndex]);

        root.left = DFS(preorder, preBegin + 1, preBegin + 1 + rootIndex - inBegin, inorder, inBegin, rootIndex);
        root.right = DFS(preorder, preBegin + 1 + rootIndex - inBegin ,preEnd, inorder, rootIndex + 1, inEnd);

        return root;
    }
}
