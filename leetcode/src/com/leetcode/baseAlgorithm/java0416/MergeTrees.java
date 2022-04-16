package com.leetcode.baseAlgorithm.java0416;

import com.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author zyh
 * @Date 2022/4/16 1:35 下午
 * @Version 1.0
 */

/*
* 617: 给你两棵二叉树： root1 和 root2 。
*   想象一下，当你将其中一棵覆盖到另一棵之上时，两棵树上的一些节点将会重叠（而另一些不会）。
*   你需要将这两棵树合并成一棵新二叉树。
*   合并的规则是：如果两个节点重叠，那么将这两个节点的值相加作为合并后节点的新值；
*       否则，不为 null 的节点将直接作为新二叉树的节点。
*   返回合并后的二叉树。
* */
public class MergeTrees {
    /*
    * 序列化与反序列化行不通，因为涉及到null节点的问题，涉及情况太多
    * */
    public static TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        List<Integer> tree1 = getArrTree(root1);
        List<Integer> tree2 = getArrTree(root2);
        int len1 = tree1.size(), len2 = tree2.size();
        List<Integer> res = new ArrayList<>();
        if(len1 < len2){
            for(int i = 0 ; i < len1 ; i++){
                res.add(tree1.get(i) + tree2.get(i));
            }
            for(int i = len1 ; i < len2 ;i++){
                res.add(tree2.get(i));
            }
        }else if(len1 > len2){
            for(int i = 0 ; i < len2 ; i++){
                res.add(tree1.get(i) + tree2.get(i));
            }
            for(int i = len2 ; i < len1 ;i++){
                res.add(tree1.get(i));
            }
        }else{
            for(int i = 0 ; i < len1 ; i++){
                res.add(tree1.get(i) + tree2.get(i));
            }
        }
        return getTreeByArr(res);
    }

    //序列化树
    public static List<Integer> getArrTree(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        List<Integer> res = new ArrayList<>();
        while(!queue.isEmpty()){
            TreeNode newNode = queue.poll();
            if(newNode != null){
                res.add(newNode.val);
                queue.add(newNode.left);
                queue.add(newNode.right);
            }else{
                res.add(0);
            }
        }
        return res;
    }

    //反序列化
    public static TreeNode getTreeByArr(List<Integer> treeArr){
        TreeNode root = new TreeNode(treeArr.get(0));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int i = 1;
        while(!queue.isEmpty()){
            TreeNode newNode = queue.poll();
            if(!treeArr.get(i).equals(0)){
                newNode.left = new TreeNode(treeArr.get(i));
                queue.add(newNode.left);
            }
            i++;
            if(!treeArr.get(i).equals(0)){
                newNode.right = new TreeNode(treeArr.get(i));
                queue.add(newNode.right);
            }
            i++;
        }
        return root;
    }

    /*
    * BFS：创建三个队列
    *   mergeQueue: 用于合并
    *   queue1、queue2 : 用于BFS
    * */
    public TreeNode mergeTrees1(TreeNode t1, TreeNode t2) {
        if(t1 == null){
            return t2;
        }
        if(t2 == null){
            return t1;
        }
        TreeNode mergeRoot = new TreeNode(t1.val + t2.val);
        Queue<TreeNode> mergeQueue = new LinkedList<>();
        Queue<TreeNode> queue1 = new LinkedList<>();
        Queue<TreeNode> queue2 = new LinkedList<>();
        mergeQueue.add(mergeRoot);
        queue1.add(t1);
        queue2.add(t2);
        while(!queue1.isEmpty() && !queue2.isEmpty()){
            TreeNode newNode = mergeQueue.poll(), node1 = queue1.poll() , node2 = queue2.poll();
            TreeNode left1 = node1.left , left2 = node2.left , right1 = node1.right , right2 = node2.right;
            if(left1 != null || left2 != null){
                if(left1 != null && left2 != null){
                    TreeNode left = new TreeNode(left1.val + left2.val);
                    newNode.left = left;
                    mergeQueue.add(newNode.left);
                    queue1.add(left1);
                    queue2.add(left2);
                }else if(left1 != null){
                    newNode.left = left1;
                }else if(left2 != null){
                    newNode.left = left2;
                }
            }
            if (right1 != null || right2 != null) {
                if (right1 != null && right2 != null) {
                    TreeNode right = new TreeNode(right1.val + right2.val);
                    newNode.right = right;
                    mergeQueue.offer(right);
                    queue1.offer(right1);
                    queue2.offer(right2);
                } else if (right1 != null) {
                    newNode.right = right1;
                } else {
                    newNode.right = right2;
                }
            }
        }
        return mergeRoot;
    }

    /*
    * DFS
    * */
    public TreeNode mergeTrees2(TreeNode t1, TreeNode t2) {
        if (t1 == null) {
            return t2;
        }
        if (t2 == null) {
            return t1;
        }
        TreeNode mergeNode = new TreeNode(t1.val + t2.val);
        mergeNode.left = mergeTrees2(t1.left , t2.left);
        mergeNode.right = mergeTrees2(t1.right , t2.right);
        return mergeNode;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode tree1 = new TreeNode(2);
        TreeNode tree2 = new TreeNode(3);
        root.left = tree1;
        root.right = tree2;
        TreeNode tree3 = new TreeNode(5);
        tree1.left = tree3;
        tree1.right = null;
        tree2.left = null;
        tree2.right = null;

        getArrTree(root).stream().forEach(System.out::println);

    }
}
