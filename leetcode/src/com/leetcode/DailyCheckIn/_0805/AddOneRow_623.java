package com.leetcode.DailyCheckIn._0805;

import com.leetcode.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author zyh
 * @Date 2022/8/5 7:35 下午
 * @Version 1.0
 */
public class AddOneRow_623 {
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int curRow = 0;
        if(depth == 1){
            TreeNode newRoot = new TreeNode(val);
            newRoot.left = root;
            return newRoot;
        }
        while(!queue.isEmpty()){
            curRow++;
            int size = queue.size();
            while(size > 0){
                TreeNode curNode = queue.poll();
                size--;
                TreeNode oldLeft = null;
                TreeNode oldRight = null;
                if(curNode.left != null){
                    queue.add(curNode.left);
                    oldLeft = curNode.left;
                }
                if(curNode.right != null){
                    queue.add(curNode.right);
                    oldRight = curNode.right;
                }
                if(curRow == depth - 1){
                    curNode.left = new TreeNode(val);
                    curNode.right = new TreeNode(val);
                    curNode.left.left = oldLeft;
                    curNode.right.right = oldRight;
                }
            }
        }
        return root;
    }
}
