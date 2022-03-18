package com.leetcode.java0314;

import com.leetcode.ListNode;
import com.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
* 从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。
* */
public class LevelOrder2 {
    public List<List<Integer>> levelOrder2(TreeNode root) {
        ArrayList<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        if(root != null){
            queue.add(root);
        }
        while(!queue.isEmpty()){
            ArrayList<Integer> temp = new ArrayList<>();
            //即使queue的长度在变化，用这种方式声明循环也是可以的；因为i的初始化只有一次，相当于一个定值
            //将同层的节点出队并写入list即可，同时维护好新的队列
            for(int i = queue.size() ; i > 0 ; i--){
                TreeNode curNode = queue.poll();
                temp.add(curNode.val);
                if(curNode.left != null) queue.add(curNode.left);
                if(curNode.right != null) queue.add(curNode.right);
            }
            res.add(temp);
        }
        return res;
    }
}
