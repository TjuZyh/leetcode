package com.leetcode.DMSXL.binaryTree;

import com.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author zyh
 * @Date 2022/11/22 15:26
 * @Version 1.0
 */
public class PostorderTraversal_145 {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        DFS(root, ans);
        return ans;
    }

    public void DFS(TreeNode node, List<Integer> ans) {
        if(node == null) return;

        DFS(node.left, ans);
        DFS(node.right, ans);
        ans.add(node.val);
    }
}
