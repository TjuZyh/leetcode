package com.leetcode.DMSXL.binaryTree;

import com.leetcode.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author zyh
 * @Date 2022/11/26 23:50
 * @Version 1.0
 */
public class InvertTree_226 {
    /*
    * BFS
    * */
    public TreeNode invertTree(TreeNode root) {
        if(root == null) return null;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if(cur.left != null) {
                queue.add(cur.left);
            }
            if(cur.right != null) {
                queue.add(cur.right);
            }
            TreeNode temp = cur.left;
            cur.left = cur.right;
            cur.right = temp;
        }
        return root;
    }

    /*
    * 递归
    * */
    public TreeNode invertTree2(TreeNode root) {
        if(root == null) return null;

        TreeNode left = invertTree2(root.left);
        TreeNode right = invertTree2(root.right);
        root.left = right;
        root.right = left;

        return root;
    }
}
