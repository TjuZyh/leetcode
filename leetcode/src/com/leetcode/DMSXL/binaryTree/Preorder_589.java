package com.leetcode.DMSXL.binaryTree;

import com.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author zyh
 * @Date 2022/11/27 00:11
 * @Version 1.0
 */
/*
* 给定一个 n 叉树的根节点 root ，返回 其节点值的 前序遍历
* */
public class Preorder_589 {
    public List<Integer> preorder(Node root) {
        List<Integer> ans = new ArrayList<>();
        DFS(root, ans);

        return ans;
    }

    public void DFS(Node node, List<Integer> ans) {
        if(node == null) return;

        ans.add(node.val);
        List<Node> child = node.children;
        for(Node n : child) {
            DFS(n, ans);
        }
    }
}
