package com.leetcode.java0314;

import com.leetcode.TreeNode;

import java.util.*;

/*
* 请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，
* 第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推。
* */
public class LevelOrder3 {
    /*
    * 解题思路：和上一道题的BFS思路相同，就是按层打印数组时，需要先判断层的单双，后利用栈进行反转数组即可
    * */
    public List<List<Integer>> levelOrder(TreeNode root) {
        ArrayList<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        Stack<TreeNode> stack = new Stack<>();
        if(root != null){
            queue.add(root);
        }
        int flag = 1;
        while(!queue.isEmpty()){
            ArrayList<Integer> temp = new ArrayList<>();
            //即使queue的长度在变化，用这种方式声明循环也是可以的；因为i的初始化只有一次，相当于一个定值
            //将同层的节点出队并写入list即可，同时维护好新的队列
            for(int i = queue.size() ; i > 0 ; i--){
                TreeNode curNode = queue.poll();
                if(flag % 2 != 0){
                    temp.add(curNode.val);
                }else {
                    stack.push(curNode);
                }
                if(curNode.left != null) queue.add(curNode.left);
                if(curNode.right != null) queue.add(curNode.right);
            }
            if(flag % 2 != 0){
                res.add(temp);
            }else {
                while(!stack.isEmpty()){
                    temp.add(stack.pop().val);
                }
                res.add(temp);
            }
            flag++;
        }
        return res;
    }
}
