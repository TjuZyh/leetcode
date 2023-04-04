package com.leetcode.DMSXL.dynamicProgramming;

import com.leetcode.TreeNode;

import java.util.HashMap;
import java.util.Map;

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
public class RobIII_337_2 {
    /*
    * 记忆化递归
    * */
    Map<TreeNode, Integer> map;

    public int rob(TreeNode root) {
        map = new HashMap<>();
        return rob3(root);
    }


    public int rob3(TreeNode root) {
        if(root == null) {
            return 0;
        }
        if(map.containsKey(root)) {
            return map.get(root);
        }
        //偷，则子节点不偷，但子节点的子节点可偷
        int rob = root.val;
        if(root.left != null) {
            rob += rob3(root.left.left) + rob3(root.left.right);
        }
        if(root.right != null) {
            rob += rob3(root.right.left) + rob3(root.right.right);
        }
        //不偷，则可偷子节点
        int noRob = rob3(root.left) + rob3(root.right);

        int max = Math.max(rob, noRob);
        map.put(root, max);
        return max;
    }
}
