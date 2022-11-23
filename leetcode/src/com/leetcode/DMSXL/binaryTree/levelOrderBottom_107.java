package com.leetcode.DMSXL.binaryTree;

import com.leetcode.TreeNode;

import java.util.*;

/**
 * @Author zyh
 * @Date 2022/11/23 23:50
 * @Version 1.0
 */
/*
* 给你二叉树的根节点 root ，返回其节点值 自底向上的层序遍历 。
* */
public class levelOrderBottom_107 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null) return ans;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            int len = queue.size();
            List<Integer> list = new ArrayList<>();
            while(len > 0) {
                len--;
                TreeNode cur = queue.poll();
                list.add(cur.val);
                if(cur.left != null) {
                    queue.add(cur.left);
                }
                if(cur.right != null) {
                    queue.add(cur.right);
                }
            }
            ans.add(list);
        }
        Collections.reverse(ans);
        return ans;
    }
}
