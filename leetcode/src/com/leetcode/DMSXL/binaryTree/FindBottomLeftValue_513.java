package com.leetcode.DMSXL.binaryTree;

import com.leetcode.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author zyh
 * @Date 2022/12/7 21:50
 * @Version 1.0
 */
/*
* 给定一个二叉树的 根节点 root，请找出该二叉树的 最底层 最左边 节点的值
* */
public class FindBottomLeftValue_513 {
    /*
    * BFS: 先获取树的层数，BFS到最后一层时返回队列的第一个节点的值即可
    * */
    public int findBottomLeftValue(TreeNode root) {
        if(root == null) return 0;
        int depth = getDepth(root);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int curDepth = 0;
        while(!queue.isEmpty()) {
            int len = queue.size();
            curDepth++;
            while(len > 0) {
                len--;
                TreeNode cur = queue.poll();
                if(curDepth == depth) {
                    return cur.val;
                }
                if(cur.left != null) {
                    queue.add(cur.left);
                }
                if(cur.right != null) {
                    queue.add(cur.right);
                }
            }
        }
        return 0;
    }

    public int getDepth(TreeNode node) {
        if(node == null) return 0;
        return Math.max(getDepth(node.left), getDepth(node.right)) + 1;
    }

    /*
    * BFS: 每一层从右向左遍历，这样遍历到的最后一个节点即为左下角的节点
    * */
    public int findBottomLeftValue2(TreeNode root) {
        if(root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int ans = 0;
        while(!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if(cur.right != null) {
                queue.add(cur.right);
            }
            if(cur.left != null) {
                queue.add(cur.left);
            }
            ans = cur.val;
        }
        return ans;
    }

    /*
    * DFS先遍历左子树，然后再遍历右子树，所以对同一高度的所有节点，最左节点肯定是最先被遍历到
    *   curVal为当前curHeight的最左节点
    *   在DFS的过程利用height记录遍历到的高度，遍历是先遍历左子节点，若该节点高度大于当前记录的高度，
    *   则证明这是下一层的最左边节点，则将curVal更新
    * */
    int curHeight = 0;
    int curVal = 0;

    public int findBottomLeftValue3(TreeNode root) {
        dfs(root, 0);
        return curVal;
    }

    public void dfs(TreeNode node, int height) {
        if(node == null) return;

        height++;
        dfs(node.left, height);
        dfs(node.right, height);

        if(height > curHeight) {
            curHeight = height;
            curVal = node.val;
        }
    }

}
