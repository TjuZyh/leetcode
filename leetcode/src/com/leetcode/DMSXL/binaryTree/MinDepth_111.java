package com.leetcode.DMSXL.binaryTree;

import com.leetcode.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author zyh
 * @Date 2022/11/25 23:59
 * @Version 1.0
 */
/*
* 给定一个二叉树，找出其最小深度
* */
public class MinDepth_111 {
    /*
    * BFS
    * */
    public int minDepth(TreeNode root) {
        if(root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int minDepth = 1;
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
                if(cur.left == null && cur.right == null) {
                    return minDepth;
                }
            }
            minDepth++;
        }
        return minDepth;
    }

    /*
    * DFS：分治思想
    * */
    public int minDepth2(TreeNode root) {
        if(root == null){
            return 0;
        }else if(root.left == null) {
            return minDepth2(root.right) + 1;
        }else if(root.right == null) {
            return minDepth2(root.left) + 1;
        }else {
            return Math.min(minDepth2(root.left), minDepth2(root.right)) + 1;
        }
    }

    /*
    * DFS剪枝
    * */
    int minDepth = Integer.MAX_VALUE;

    public int minDepth3(TreeNode root) {
        if(root == null) return 0;
        DFS(root, 1);
        return minDepth;
    }

    public void DFS(TreeNode node, int level) {
        if(node == null) return;

        if(level >= minDepth) return;

        if(node.left == null && node.right == null){
            minDepth = Math.min(level, minDepth);
        }

        DFS(node.left, level + 1);
        DFS(node.right, level + 1);
    }





}
