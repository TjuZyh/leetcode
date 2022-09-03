package com.leetcode.DailyCheckIn._0902;

import com.leetcode.TreeNode;

import java.util.List;

/**
 * @Author zyh
 * @Date 2022/9/2 20:22
 * @Version 1.0
 */
/*
* DFS解决二叉树路径问题
* */
public class DFSModel {
    //自顶向下模板
    private List<List<Integer>> res;
    public void dfs(TreeNode root , List<Integer> path){
        if(root == null) return;
        //选择当前元素是否加入到路径中
        path.add(root.val);
        //叶子节点，即到达路径尽头，在res添加路径，并返回
        if(root.left == null && root.right == null){
            res.add(path);
            return;
        }
        //递归左右子树
        dfs(root.left , path);
        dfs(root.right, path);
    }

    //非自顶向下
    private int ans = 0;
    public int dfs2(TreeNode root){
        if(root == null) return 0;
        int left = dfs2(root.left);
        int right = dfs2(root.right);
        ans = Math.max(ans , left + right + root.val);
        return Math.max(left , right);
    }



}
