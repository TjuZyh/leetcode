package com.leetcode.DMSXL.binaryTree;

import com.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author zyh
 * @Date 2022/11/22 15:30
 * @Version 1.0
 */
public class InorderTraversal_94 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        DFS(root, ans);
        return ans;
    }

    public void DFS(TreeNode node, List<Integer> ans) {
        if(node == null) return;

        DFS(node.left, ans);
        ans.add(node.val);
        DFS(node.right, ans);
    }
}
