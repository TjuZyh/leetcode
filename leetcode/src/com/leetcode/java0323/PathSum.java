package com.leetcode.java0323;

import com.leetcode.TreeNode;

import java.util.LinkedList;
import java.util.List;

/*
* 给你二叉树的根节点 root 和一个整数目标和 targetSum ，找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。
* */
public class PathSum {
    /*
    * 回溯
    *   终止条件：节点root为空
    *   递归流程：
    *       1. 路径更新：将当前节点值root.val加入路径path
    *       2. 目标值更新：target -= root.val
    *       3. 路径记录：当root为叶子节点 并且 路径值等于目标值，则将路径加入res
    *       4. 先序遍历：递归该当前节点的左/右节点
    *       5. 路径恢复：向上回溯前，需要将当前节点从path中删除
    * */
    //创建结果列表res
    LinkedList<List<Integer>> res = new LinkedList<>();
    //创建路径列表path
    LinkedList<Integer> path = new LinkedList<>();
    public List<List<Integer>> pathSum(TreeNode root, int target) {
        recur(root , target);
        return res;
    }

    public void recur(TreeNode root , int target){
        if(root == null) return;
        path.add(root.val);
        target -= root.val;
        if(target == 0 && root.left == null && root.right == null){
            //注意这里要new出一个新list，否则后续回溯会改变path，res中存入的path也会随之改变
            res.add(new LinkedList<>(path));
        }
        recur(root.left , target);
        recur(root.right , target);
        //回溯，将路径恢复
        path.removeLast();
    }
}
