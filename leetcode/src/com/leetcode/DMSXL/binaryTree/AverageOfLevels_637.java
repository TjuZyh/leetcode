package com.leetcode.DMSXL.binaryTree;

import com.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author zyh
 * @Date 2022/11/24 00:19
 * @Version 1.0
 */
/*
* 给定一个非空二叉树的根节点 root , 以数组的形式返回每一层节点的平均值
* */
public class AverageOfLevels_637 {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> ans = new ArrayList<>();
        if(root == null) return ans;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            int len = queue.size();
            double sum = 0;
            int cnt = len;
            while(len > 0) {
                len--;
                TreeNode cur = queue.poll();
                if(cur.left != null) {
                    queue.add(cur.left);
                }
                if(cur.right != null) {
                    queue.add(cur.right);
                }
                sum += cur.val;
            }
            ans.add(sum / cnt);
        }
        return ans;
    }
}
