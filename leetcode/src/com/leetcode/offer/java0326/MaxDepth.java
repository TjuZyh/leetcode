package com.leetcode.offer.java0326;

import com.leetcode.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/*
* 输入一棵二叉树的根节点，求该树的深度。
* 从根节点到叶节点依次经过的节点（含根、叶节点）形成树的一条路径，最长路径的长度为树的深度。
* */
public class MaxDepth {
    /*
    * BFS
    * */
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        int res = 0;
        queue.add(root);
        while(!queue.isEmpty()){
            for(int i = queue.size() ; i > 0 ; i--){
                TreeNode curNode = queue.poll();
                if(curNode.left != null){
                    queue.add(curNode.left);
                }
                if(curNode.right != null){
                    queue.add(curNode.right);
                }
            }
            res++;
        }
        return res;
    }

    /*
    * DFS：后序遍历
    *   1. 终止条件：root为空，说明已经越过叶子节点，返回深度0
    *   2. 递推工作：
    *       1. 计算root左子树的深度
    *       2. 计算root右子树的深度
    *   3. 返回值：
    *       返回此树的深度，即 max（左子树的深度，右子树的深度）+ 1
    * */
    public int maxDepth1(TreeNode root) {
        if(root == null) return 0;
        return Math.max(maxDepth1(root.left) , maxDepth1(root.right)) + 1;
    }

}
