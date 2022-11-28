package com.leetcode.DMSXL.binaryTree;

import com.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author zyh
 * @Date 2022/11/28 22:52
 * @Version 1.0
 */
/*
* 给你一个二叉树的根节点 root ， 检查它是否轴对称
*   输入：root = [1,2,2,3,4,4,3]
*   输出：true
* */
public class IsSymmetric_101 {
    //递归的比较左节点和右节点，如果相等则递归比较左节点的左节点和右节点的右节点以及左节点的右节点以及右节点的左节点
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        return DFS(root.left, root.right);
    }

    /*
    * 终止条件：
    *   1. left 和 right 不等，或者 left 和 right 都为空
    *   2. 递归的比较 left，left 和 right.right，递归比较 left，right 和 right.left
    * */
    public boolean DFS(TreeNode left, TreeNode right) {
        if(left == null && right == null) return true;

        if(left == null || right == null) return false;

        if(left.val != right.val) return false;

        return DFS(left.left, right.right) && DFS(left.right, right.left);
    }

    /*
    * 迭代方式
    * */
    public boolean isSymmetric2(TreeNode root) {
        if(root == null || (root.left == null && root.right == null)) {
            return true;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root.left);
        queue.add(root.right);
        while(!queue.isEmpty()) {
            TreeNode left = queue.poll();
            TreeNode right = queue.poll();
            if(left == null && right == null) {
                continue;
            }
            if(left == null || right == null) {
                return false;
            }
            if(left.val != right.val) {
                return false;
            }
            queue.add(left.left);
            queue.add(right.right);
            queue.add(left.right);
            queue.add(right.left);
        }
        return true;
    }
}
