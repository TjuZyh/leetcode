package com.leetcode.DailyCheckIn._0902;

import com.leetcode.TreeNode;

import java.util.*;

/**
 * @Author zyh
 * @Date 2022/9/2 16:07
 * @Version 1.0
 */
public class LongestUniValuePath_687 {
    class Tuple{
        private TreeNode node;
        private Integer curPathVal;

        public Tuple(TreeNode node, Integer curPathVal) {
            this.node = node;
            this.curPathVal = curPathVal;
        }
    }
    /*
    * BFS行不通.... 无法判断[1,1,1,1,null,null,1]这类的情况, 路径涉及到多层无法做
    * */
    public int longestUniValuePath(TreeNode root) {
        if(root == null){
            return 0;
        }
        int maxPath = 0;
        Deque<Tuple> queue = new ArrayDeque<>();
        queue.add(new Tuple(root , 0));
        while(!queue.isEmpty()){
            int size = queue.size();
            while(size > 0){
                --size;
                Tuple tuple = queue.poll();
                TreeNode curNode = tuple.node;
                Integer curPathVal = tuple.curPathVal;
                maxPath = Math.max(maxPath , curPathVal);
                if(curNode.left != null){
                    if(curNode.left.val == curNode.val && curNode.right != null && curNode.right.val == curNode.val){
                        queue.add(new Tuple(curNode.left ,  2));
                    }else if(curNode.left.val == curNode.val){
                        queue.add(new Tuple(curNode.left , curPathVal + 1));
                    }else {
                        queue.add(new Tuple(curNode.left , 0));
                    }
                }
                if(curNode.right != null){
                    if(curNode.right.val == curNode.val && curNode.left != null && curNode.left.val == curNode.val){
                        queue.add(new Tuple(curNode.right , 2));
                    }else if(curNode.right.val == curNode.val){
                        queue.add(new Tuple(curNode.right , curPathVal + 1));
                    }else {
                        queue.add(new Tuple(curNode.right , 0));
                    }
                }
            }
        }
        return maxPath;
    }
    /*
    * DFS
    * */
    private int res;

    public int longestUniValuePath1(TreeNode root){
        res = 0;
        dfs(root);
        return res;
    }

    /*
    * dfs: 返回当前节点下的最长路径（即返回其左子树或右子树最大的值）
    * */
    public int dfs(TreeNode root){
        if(root == null){
            return 0;
        }
        int left = dfs(root.left) , right = dfs(root.right);
        int left1 = 0 , right1 = 0;
        if(root.left != null && root.left.val == root.val){
            left1 = left + 1;
        }
        if(root.right != null && root.right.val == root.val){
            right1 = right + 1;
        }
        res = Math.max(res , left1 + right1);
        return Math.max(left1 , right1);
    }
}
