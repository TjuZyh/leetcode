package com.leetcode.DMSXL.binaryTree;

import com.leetcode.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author zyh
 * @Date 2022/12/6 22:21
 * @Version 1.0
 */
/*
* 给定二叉树的根节点 root ，返回所有左叶子之和
* */
public class SumOfLeftLeaves_404 {
    /*
    * BFS
    *   1. 判断该节点的左节点是否为叶子节点，如果是则累加
    *   2. 为节点添加额外信息，创建Entity类，额外记录节点的左右
    * */
    public int sumOfLeftLeaves(TreeNode root) {
        if(root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int sum = 0;
        while(!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if(cur.left != null) {
                //判断左子叶是否为叶子节点
                if(cur.left.left == null && cur.left.right == null) {
                    sum += cur.left.val;
                }else {
                    queue.add(cur.left);
                }
            }
            if(cur.right != null) {
                //这里可以剪枝，如果当前节点的右子节点为叶子节点，就不加到queue中了
                //如果不为叶子节点，则继续BFS
                if(cur.right.left != null || cur.right.right != null) {
                    queue.add(cur.right);
                }

            }
        }
        return sum;
    }

    /*
    * DFS : 设定全局变量，DFS满足条件的更新全局变量即可
    * */
    int sum = 0;

    public int sumOfLeftLeaves2(TreeNode root) {
        if(root == null) return 0;
        DFS(root);
        return sum;
    }

    public void DFS(TreeNode node) {
        if(node == null) return;

        if(node.left != null) {
            if(node.left.left == null && node.left.right == null) {
                sum += node.left.val;
            }
        }

        DFS(node.left);
        DFS(node.right);
    }

    public int sumOfLeftLeaves3(TreeNode root) {
        if(root == null) return 0;

        int ans = 0;

        if(root.left != null && root.left.left == null && root.left.right == null) {
            ans += root.left.val;
        }
        return sumOfLeftLeaves3(root.left) + sumOfLeftLeaves3(root.right) + ans;
    }
}


