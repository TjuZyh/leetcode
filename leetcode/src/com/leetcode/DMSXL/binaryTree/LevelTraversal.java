package com.leetcode.DMSXL.binaryTree;

import com.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author zyh
 * @Date 2022/11/22 15:00
 * @Version 1.0
 */
public class LevelTraversal {
    /*
    * 层序遍历：DFS
    * */
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> levelOrder(TreeNode root) {
        DFS(root, 0);
        return ans;
    }

    public void DFS(TreeNode node, Integer deep) {
        if(node == null) return;
        deep++;

        if(ans.size() < deep) {
            List<Integer> item = new ArrayList<>();
            ans.add(item);
        }
        ans.get(deep - 1).add(node.val);

        DFS(node.left, deep);
        DFS(node.right, deep);
    }

    /*
    * 层序遍历：BFS
    * */
    public List<List<Integer>> levelOrder2(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            int len = queue.size();
            List<Integer> list = new ArrayList<>();
            while(len > 0) {
                len--;
                TreeNode cur = queue.poll();
                list.add(cur.val);
                if(cur.left != null) {
                    queue.add(cur.left);
                }
                if(cur.right != null) {
                    queue.add(cur.right);
                }
            }
            res.add(list);
        }
        return res;
    }
}
