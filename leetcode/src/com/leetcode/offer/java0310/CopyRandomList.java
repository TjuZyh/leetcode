package com.leetcode.offer.java0310;

import java.util.HashMap;
import java.util.Map;

class Node{
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

public class CopyRandomList {
    //利用哈希表记录每一个节点对应新节点的创建情况
    Map<Node , Node> cachedNode = new HashMap<Node , Node>();

    public Node copyRandomList(Node head) {
        if(head == null) return null;
        //检查「当前节点的后继节点」和「当前节点的随机指针指向的节点」的创建情况；
        //如果这两个节点中的任何一个节点的新节点没有被创建，立刻递归地进行创建
        while(!cachedNode.containsKey(head)){
            Node newNode = new Node(head.val);
            cachedNode.put(head , newNode);
            newNode.next = copyRandomList(head.next);
            newNode.random = copyRandomList(head.random);
        }
        //如果已经拷贝过，可以直接从哈希表中取出拷贝后的节点的指针并返回即可
        return cachedNode.get(head);
    }
}
