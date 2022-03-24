package com.leetcode.java0323;

import com.leetcode.Node;

public class TreeToDoublyList {
    /*
    * 排序列表：节点从大到小排序，因此可以使用中序遍历访问树节点
    * */
    Node pre , head;
    public Node treeToDoublyList(Node root) {
        if(root == null) return null;
        dfs(root);
        head.left = pre;
        pre.right = head;
        return head;
    }

    public void dfs(Node cur){
        if(cur == null) return;
        dfs(cur.left);
        if(pre != null) pre.right = cur;
        else head = cur;
        cur.left = pre;
        pre = cur;
        dfs(cur.right);
    }
}
