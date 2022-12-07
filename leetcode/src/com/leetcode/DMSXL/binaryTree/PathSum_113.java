package com.leetcode.DMSXL.binaryTree;

import com.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author zyh
 * @Date 2022/12/7 22:45
 * @Version 1.0
 */
/*
* 给你二叉树的根节点 root 和一个整数目标和 targetSum ，找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径
* */
public class PathSum_113 {
    /*
    * 递归: 注意这种方法由于java中list引用传递，为了防止递归的时候分支污染，要在每个路径创建新的list
    *   但是要递归的时候一直创建list的实例，效率很差
    * */
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        dfs(root, targetSum, 0, new ArrayList<>());
        return ans;
    }

    public void dfs(TreeNode node, int targetSum, int curSum, List<Integer> curPath) {
        if(node == null) return;

        //必须要创建新的list，不然只new了一次，一直都是在一个list中操作
        List<Integer> path = new ArrayList<>(curPath);

        curSum += node.val;
        path.add(node.val);

        if(node.left == null && node.right == null) {
            if(curSum == targetSum){
                ans.add(path);
                return;
            }
        }

        dfs(node.left, targetSum, curSum, path);
        dfs(node.right, targetSum, curSum, path);
    }

    /*
    * 递归 + 回溯
    * */
    List<List<Integer>> paths = new ArrayList<>();
    public List<List<Integer>> pathSum2(TreeNode root, int targetSum) {
        dfs2(root, targetSum, 0, new ArrayList<>());
        return paths;
    }

    public void dfs2(TreeNode node, int targetSum, int curSum, List<Integer> path) {
        if(node == null) return;

        curSum += node.val;
        path.add(node.val);

        if(node.left == null && node.right == null) {
            if(curSum == targetSum) {
                //注意这里一定要new新的list再添加，否则DFS到别的分支会修改path
                paths.add(new ArrayList<>(path));
            }
            path.remove(path.size() - 1);
            return;
        }

        dfs2(node.left, targetSum, curSum, path);
        dfs2(node.right, targetSum, curSum, path);

        path.remove(path.size() - 1);
    }
}
