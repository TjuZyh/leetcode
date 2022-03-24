package com.leetcode.java0323;

import com.leetcode.TreeNode;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/*
* 给定一棵二叉搜索树，请找出其中第 k 大的节点的值。
* */
public class KthLargest {
    /*
    * DFS + heap
    * */
    public int kthLargest(TreeNode root, int k) {
        if(root == null) return 0;
        Queue<TreeNode> queueForTree = new LinkedList<>();
        queueForTree.add(root);
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });
        while(!queueForTree.isEmpty()){
            TreeNode curNode = queueForTree.poll();
            pq.add(curNode.val);
            if(pq.size() > k){
                pq.poll();
            }
            if(curNode.left != null){
                queueForTree.add(curNode.left);
            }
            if(curNode.right != null){
                queueForTree.add(curNode.right);
            }
        }
        return pq.poll();
    }

    /*
    * 二叉搜索树的 中序遍历倒序 为 递减序列
    * 问题转化为：此树的中序遍历倒序的第 k 个节点
    * */
    int res , k;
    public int kthLargest1(TreeNode root, int k) {
        this.k = k;
        dfs(root);
        return res;
    }

    public void dfs(TreeNode root){
        if(root == null) return;
        dfs(root.right);
        if(k == 0) return;
        if(--k == 0) res = root.val;
        dfs(root.left);
    }
}
