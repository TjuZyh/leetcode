package com.leetcode.DMSXL.binaryTree;

import com.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author zyh
 * @Date 2022/11/24 21:48
 * @Version 1.0
 */
/*
* 给定一个 N 叉树，返回其节点值的层序遍历。（即从左到右，逐层遍历）
* */
public class LevelOrder_429 {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null) return ans;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            int len = queue.size();
            List<Integer> list = new ArrayList<>();
            while(len > 0) {
                len--;
                Node cur = queue.poll();
                if(cur.children != null) {
                    List<Node> child = cur.children;
                    for(Node node : child) {
                        queue.add(node);
                    }
                }
                list.add(cur.val);
            }
            ans.add(list);
        }
        return ans;
    }
}

class Node{
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}
