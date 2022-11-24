package com.leetcode.DMSXL.binaryTree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author zyh
 * @Date 2022/11/24 22:05
 * @Version 1.0
 */
/*
* 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL
* */
public class Connect_116 {
    public Node2 connect(Node2 root) {
        if(root == null) return null;
        Queue<Node2> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            int len = queue.size();
            while (len > 0) {
                len--;
                Node2 cur = queue.poll();
                if(cur.left != null) {
                    queue.add(cur.left);
                }
                if(cur.right != null) {
                    queue.add(cur.right);
                }
                if(len == 0) {
                    cur.next = null;
                }else {
                    cur.next = queue.peek();
                }
            }
        }
        return root;
    }
}

class Node2 {
    public int val;
    public Node2 left;
    public Node2 right;
    public Node2 next;

    public Node2() {}

    public Node2(int _val) {
        val = _val;
    }

    public Node2(int _val, Node2 _left, Node2 _right, Node2 _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
