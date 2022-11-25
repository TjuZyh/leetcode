package com.leetcode.DMSXL.binaryTree;

import com.leetcode.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author zyh
 * @Date 2022/11/25 23:38
 * @Version 1.0
 */
/*
* 给定一个二叉树，找出其最大深度
* */
public class MaxDepth_104 {
    /*
    * BFS
    * */
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        int depth = 0;
        queue.add(root);
        while(!queue.isEmpty()) {
            int len = queue.size();
            while(len > 0) {
                len--;
                TreeNode cur = queue.poll();
                if(cur.left != null) {
                    queue.add(cur.left);
                }
                if(cur.right != null) {
                    queue.add(cur.right);
                }
            }
            depth++;
        }
        return depth;
    }

    /*
    * DFS：分治思路
    * */
    public int maxDepth2(TreeNode root) {
        if(root == null){
            return 0;
        }else {
            int leftHeight = maxDepth2(root.left);
            int rightHeight = maxDepth2(root.right);
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }

    /*
    * DFS:利用level标记当前层
    * */
    int depth = 0;

    public int maxDepth3(TreeNode root) {
        if(root == null) return 0;
        DFS(root, 1);
        return depth;
    }

    public void DFS(TreeNode node, int level) {
        if(node == null) return;
        depth = Math.max(depth, level);
        DFS(node.left, level + 1);
        DFS(node.right, level + 1);
    }

}
