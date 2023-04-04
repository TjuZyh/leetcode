package com.leetcode.DMSXL.dynamicProgramming;

import com.leetcode.TreeNode;

/**
 * @Author zyh
 * @Date 2023/4/4 21:40
 * @Version 1.0
 */
/*
* 房屋之间以二叉树状排列
*   输入: root = [3,2,3,null,3,null,1]
*   输出: 7
* */
public class RobIII_337 {
    /*
    * 树形dp
    *   1. dp[0,1]：长度为2的数组
    *       dp[0]: 不偷当前节点的最大金额
    *       dp[1]: 偷当前节点的最大金额
    *   2. 存在两种情况，对于当前遍历到的节点：
    *       偷，则左右子节点不能偷：dp[1] = root.val + left[0] + right[0]
    *       不偷，则左右子节点可偷（但是不一定偷，而是选择子节点能偷的最大值）：
    *           dp[0] = Max(left[0], left[1]) + Max(right[0] + right[1])
    *   3. dp[0] = 0, dp[1] = node.val(叶子节点的值)
    *   4. 遍历顺序：后序遍历，因为需要先得到左右子节点后处理中节点
    * */
    public int rob(TreeNode root) {
        int[] ans = rob3(root);
        return Math.max(ans[0], ans[1]);
    }

    public int[] rob3(TreeNode root) {
        int[] res = new int[2];
        if(root == null){
            return new int[]{0, 0};
        }
        //后序遍历，先获得左右子节点值，后处理中间节点
        int[] leftSum = rob3(root.left);
        int[] rightSum = rob3(root.right);

        //不偷
        res[0] = Math.max(leftSum[0], leftSum[1]) + Math.max(rightSum[0], rightSum[1]);
        //偷
        res[1] = root.val + leftSum[0] + rightSum[0];
        return res;
    }
}
