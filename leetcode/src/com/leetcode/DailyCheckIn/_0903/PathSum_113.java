package com.leetcode.DailyCheckIn._0903;

import com.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author zyh
 * @Date 2022/9/3 13:52
 * @Version 1.0
 */
public class PathSum_113 {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if(root == null) return ans;
        LinkedList<Integer> path = new LinkedList<>();
        dfs(root , targetSum ,path);
        return ans;
    }

    public void dfs(TreeNode root , int leftSum , LinkedList<Integer> path){
        path.offer(root.val);
        if(root.left == null && root.right == null && leftSum == root.val){
            ans.add(new LinkedList<>(path));
            return;
        }
        if(root.left != null){
            dfs(root.left , leftSum - root.val , path);
            path.removeLast();
        }
        if(root.right != null){
            dfs(root.right , leftSum - root.val , path);
            path.removeLast();
        }
    }
}
