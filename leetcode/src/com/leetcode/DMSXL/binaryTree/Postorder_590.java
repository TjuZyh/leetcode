package com.leetcode.DMSXL.binaryTree;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author zyh
 * @Date 2022/11/27 00:23
 * @Version 1.0
 */
public class Postorder_590 {
    public List<Integer> postorder(Node root) {
        List<Integer> ans = new ArrayList<>();
        DFS(root, ans);
        return ans;
    }

    public void DFS(Node node, List<Integer> ans) {
        if(node == null) return;

        List<Node> child = node.children;
        for(Node n : child) {
            DFS(n, ans);
        }
        ans.add(node.val);
    }
}
