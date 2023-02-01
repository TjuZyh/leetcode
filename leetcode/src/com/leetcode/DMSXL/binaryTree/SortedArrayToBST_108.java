package com.leetcode.DMSXL.binaryTree;

import com.leetcode.TreeNode;

/**
 * @Author zyh
 * @Date 2023/1/31 21:30
 * @Version 1.0
 */
/*
* 给你一个整数数组 nums ，其中元素已经按 升序 排列，请你将其转换为一棵 高度平衡 二叉搜索树
*   输入：nums = [-10,-3,0,5,9]
*   输出：[0,-3,9,-10,null,5]
* */
public class SortedArrayToBST_108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        return constructBST(nums, 0, nums.length - 1);
    }

    //思路每次寻找数组中间的值作为树根
    public TreeNode constructBST(int[] nums, int start, int end) {
        if(start > end) {
            return null;
        }
        int rootIndex = findMidIndex(nums, start, end);
        TreeNode root = new TreeNode(nums[rootIndex]);
        root.left = constructBST(nums, start, rootIndex - 1);
        root.right = constructBST(nums, rootIndex + 1, end);
        return root;
    }

    public int findMidIndex(int[] nums, int start, int end) {
        return (end + start) / 2;
    }

    public static void main(String[] args) {
        new SortedArrayToBST_108().sortedArrayToBST(new int[]{-10,-3,0,5,9});
    }
}
