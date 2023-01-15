package com.leetcode.DMSXL.binaryTree;

import com.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author zyh
 * @Date 2022/12/15 11:08
 * @Version 1.0
 */
/*
* 给你一个二叉搜索树的根节点 root ，返回 树中任意两不同节点值之间的最小差值
* */
public class GetMinimumDifference_530 {
    /*
    * 中序遍历的序列为递增序列，判断相邻两个元素的差的最小值即可
    *   朴素的方法：先中序遍历得到升序数组，再基于数组判断最小差值
    * */
    List<Integer> list = new ArrayList<>();
    public int getMinimumDifference(TreeNode root) {
        if(root == null) return 0;
        if(root.left == null && root.right == null) return root.val;
        inOrder(root);
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < list.size() - 1; i++) {
            min = Math.min(min, Math.abs(list.get(i) - list.get(i + 1)));
        }
        return min;
    }

    public void inOrder(TreeNode node) {
        if(node == null) return;
        inOrder(node.left);
        list.add(node.val);
        inOrder(node.right);
    }

    /*
    * 边中序遍历边寻找最小差值
    * */
    int ans;
    int pre;
    public int getMinimumDifference2(TreeNode root) {
        ans = Integer.MAX_VALUE;
        pre = -1;
        dfs(root);
        return ans;
    }

    public void dfs(TreeNode node) {
        if(node == null) return;
        dfs(node.left);
        if (pre != -1) {
            ans = Math.min(ans, node.val - pre);
        }
        pre = node.val;
        dfs(node.right);
    }
}
