package com.leetcode.DMSXL.binaryTree;

/**
 * @Author zyh
 * @Date 2022/11/25 23:19
 * @Version 1.0
 */

public class Connect_117 {
    /*
    * 不利用队列进行层序遍历
    * */
    public Node2 connect(Node2 root) {
        if(root == null) return null;
        Node2 cur = root;
        while(cur != null) {
            Node2 dummy = new Node2(-1);
            //下一层的指针首
            Node2 pre = dummy;
            //通过这一层的父节点去遍历其子节点，用于填充下一层的链表
            while(cur != null) {
                if(cur.left != null) {
                    pre.next = cur.left;
                    pre = pre.next;
                }
                if(cur.right != null) {
                    pre.next = cur.right;
                    pre = pre.next;
                }
                cur = cur.next;
            }
            //将cur移到下一层
            cur = dummy.next;
        }
        return root;
    }
}
