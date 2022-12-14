package com.leetcode.DMSXL.binaryTree;

import com.leetcode.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author zyh
 * @Date 2022/12/13 22:17
 * @Version 1.0
 */
/*
* 合并二叉树
*   合并的规则是：如果两个节点重叠，那么将这两个节点的值相加作为合并后节点的新值；
*       否则，不为 null 的节点将直接作为新二叉树的节点
* */
public class MergeTrees_617 {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if(root1 == null) {
            return root2;
        }
        if(root2 == null) {
            return root1;
        }
        TreeNode root = new TreeNode(root1.val + root2.val);
        root.left = mergeTrees(root1.left, root2.left);
        root.right = mergeTrees(root1.right, root2.right);

        return root;
    }

    /*
    * BFS
    * */
    public TreeNode mergeTrees2(TreeNode root1, TreeNode root2) {
        if (root1 == null) {
            return root2;
        }
        if (root2 == null) {
            return root1;
        }
        Queue<TreeNode> mergeQueue = new LinkedList<>();
        Queue<TreeNode> queue1 = new LinkedList<>();
        Queue<TreeNode> queue2 = new LinkedList<>();
        TreeNode root = new TreeNode(root1.val + root2.val);
        mergeQueue.add(root);
        queue1.add(root1);
        queue2.add(root2);
        while (!queue1.isEmpty() && !queue2.isEmpty()) {
            TreeNode cur = mergeQueue.poll(), node1 = queue1.poll(), node2 = queue2.poll();
            if(node1.left != null || node2.left != null) {
                if(node1.left != null && node2.left != null) {
                    TreeNode left = new TreeNode(node1.left.val + node2.left.val);
                    cur.left = left;
                    mergeQueue.add(left);
                    queue1.add(node1.left);
                    queue2.add(node2.left);
                }else if(node1.left != null){
                    cur.left = node1.left;
                }else {
                    cur.left = node2.left;
                }
            }
            if(node1.right != null || node2.right != null) {
                if(node1.right != null && node2.right != null) {
                    TreeNode right = new TreeNode(node1.right.val + node2.right.val);
                    cur.right = right;
                    mergeQueue.add(right);
                    queue1.add(node1.right);
                    queue2.add(node2.right);
                }else if(node1.right != null) {
                    cur.right = node1.right;
                }else {
                    cur.right = node2.right;
                }
            }
        }
        return root;
    }
}
