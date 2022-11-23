package com.leetcode.DMSXL.binaryTree;

import com.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author zyh
 * @Date 2022/11/23 23:57
 * @Version 1.0
 */
/*
* 给定一个二叉树的 根节点 root，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值
* */
public class RightSideView_199 {
    /*
    * BFS: 由于按层遍历的顺序是从左到右，所以只保存最后一个节点值即可
    * */
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if(root == null) return ans;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            int size = queue.size();
            while(size > 0) {
                size--;
                TreeNode cur = queue.poll();
                if(cur.left != null) {
                    queue.add(cur.left);
                }
                if(cur.right != null) {
                    queue.add(cur.right);
                }
                if(size == 0) {
                    ans.add(cur.val);
                }
            }
        }
        return ans;
    }

    /*
    * DFS：按照中右左顺序遍历，保证每层都是最先访问最右边的节点
    * */
    List<Integer> res = new ArrayList<>();
    public List<Integer> rightSideView2(TreeNode root) {
        DFS(root, 0);
        return res;
    }

    public void DFS(TreeNode node, int depth) {
        if(node == null) return;

        // 先访问 当前节点，再递归地访问 右子树 和 左子树
        // 如果当前节点所在深度还没有出现在res里，说明在该深度下当前节点是第一个被访问的节点，因此将当前节点加入res中
        if(depth == res.size()) {
            res.add(node.val);
        }
        depth++;
        DFS(node.right, depth);
        DFS(node.left, depth);
    }

}
