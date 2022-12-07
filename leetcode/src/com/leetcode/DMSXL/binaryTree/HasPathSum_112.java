package com.leetcode.DMSXL.binaryTree;

import com.leetcode.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author zyh
 * @Date 2022/12/7 22:27
 * @Version 1.0
 */
/*
* 给你二叉树的根节点root 和一个表示目标和的整数targetSum 。
*   判断该树中是否存在 根节点到叶子节点 的路径，这条路径上所有节点值相加等于目标和targetSum 。
*   如果存在，返回 true ；否则，返回 false 。
* */
public class HasPathSum_112 {
    /*
    * DFS
    * */
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return DFS(root, targetSum, 0);
    }

    public boolean DFS(TreeNode node, int targetSum, int curSum) {
        if(node == null) return false;

        curSum += node.val;

        if(node.left == null && node.right == null) {
            if(curSum == targetSum) {
                return true;
            }
        }

        return DFS(node.left, targetSum, curSum) || DFS(node.right, targetSum, curSum);
    }

    /*
    * BFS
    * */
    public boolean hasPathSum2(TreeNode root, int targetSum) {
        if(root == null) return false;
        Queue<TreeNode> queueNode = new LinkedList<>();
        Queue<Integer> pathSum = new LinkedList<>();
        queueNode.add(root);
        pathSum.add(root.val);
        while(!queueNode.isEmpty()) {
            TreeNode cur = queueNode.poll();
            Integer curSum = pathSum.poll();
            if(cur.left == null && cur.right == null) {
                if(curSum == targetSum) {
                    return true;
                }
                continue;
            }
            if(cur.left != null) {
                queueNode.add(cur.left);
                pathSum.add(curSum + cur.left.val);
            }
            if(cur.right != null) {
                queueNode.add(cur.right);
                pathSum.add(curSum + cur.right.val);
            }
        }
        return false;
    }



}
