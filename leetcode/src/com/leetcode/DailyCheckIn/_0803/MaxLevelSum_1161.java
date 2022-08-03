package com.leetcode.DailyCheckIn._0803;

import com.leetcode.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author zyh
 * @Date 2022/8/3 6:15 下午
 * @Version 1.0
 */
/*
* 简单BFS题
* */
public class MaxLevelSum_1161 {
    public int maxLevelSum(TreeNode root) {
        if(root == null){
            return 0;
        }
        int max = Integer.MIN_VALUE;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int flag = 0;
        int returnVal = 0;

        while(!queue.isEmpty()){
            int queueSize = queue.size();
            int cnt = 0;
            flag++;
            while(queueSize > 0){
                TreeNode curNode = queue.poll();
                if(curNode.left != null){
                    queue.add(curNode.left);
                }
                if(curNode.right != null){
                    queue.add(curNode.right);
                }
                queueSize--;
                cnt += curNode.val;
            }
            if(cnt > max){
                max = cnt;
                returnVal = flag;
            }
        }
        return returnVal;

    }
}
