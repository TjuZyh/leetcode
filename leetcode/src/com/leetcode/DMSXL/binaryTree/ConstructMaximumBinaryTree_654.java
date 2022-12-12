package com.leetcode.DMSXL.binaryTree;

import com.leetcode.TreeNode;

/**
 * @Author zyh
 * @Date 2022/12/12 11:15
 * @Version 1.0
 */
/*
* 给定一个不重复的整数数组nums 。最大二叉树可以用下面的算法从 nums 递归地构建:
*   1.创建一个根节点，其值为nums 中的最大值。
*   2.递归地在最大值 左边 的子数组前缀上构建左子树。
*   3.递归地在最大值 右边 的子数组后缀上构建右子树。
* 返回 nums 构建的 最大二叉树 。
*
* 输入：nums = [3,2,1,6,0,5]
* 输出：[6,3,5,null,2,0,null,null,1]
* */
public class ConstructMaximumBinaryTree_654 {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return DFS(nums, 0, nums.length);
    }

    public TreeNode DFS(int[] nums, int left, int right) {
        if(left >= right) {
            return null;
        }
        int max = left;
        for(int i = left; i < right; i++) {
            if(nums[i] > nums[max]) {
                max = i;
            }
        }
        TreeNode root = new TreeNode(nums[max]);
        root.left = DFS(nums, left, max);
        root.right = DFS(nums, max + 1, right);

        return root;
    }

    public static void main(String[] args) {
        new ConstructMaximumBinaryTree_654().constructMaximumBinaryTree(new int[]{3,2,1,6,0,5});
    }
}
