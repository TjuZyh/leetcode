package com.leetcode.DMSXL.binaryTree;

import com.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author zyh
 * @Date 2022/11/22 15:18
 * @Version 1.0
 */
/*
* 给你二叉树的根节点 root ，返回它节点值的 前序 遍历
* */
public class PreorderTraversal_144 {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        DFS(root, ans);

        return ans;
    }

    public void DFS(TreeNode node, List<Integer> ans) {
        if(node == null) return;

        ans.add(node.val);
        DFS(node.left, ans);
        DFS(node.right, ans);
    }
}
