package com.leetcode.DailyCheckIn._0817;

import com.leetcode.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author zyh
 * @Date 2022/8/17 12:31
 * @Version 1.0
 */
public class DeepestLeavesSum_1302 {
    public int deepestLeavesSum(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int curSize = queue.size();
            boolean flag = false;
            int cnt = 0;
            while(curSize > 0){
                TreeNode curNode = queue.poll();
                cnt += curNode.val;
                if(curNode.left != null){
                    queue.add(curNode.left);
                    flag = true;
                }
                if(curNode.right != null){
                    queue.add(curNode.right);
                    flag = true;
                }
                --curSize;
            }
            if(!flag){
                return cnt;
            }
        }
        return 0;
    }
}
