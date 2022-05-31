package com.leetcode.DailyCheckIn._0531;

import com.leetcode.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author zyh
 * @Date 2022/5/31 9:03 下午
 * @Version 1.0
 */
/*
* 给出一棵二叉树，其上每个结点的值都是 0 或 1 。每一条从根到叶的路径都代表一个从最高有效位开始的二进制数。
*   对树上的每一片叶子，我们都要找出从根到该叶子的路径所表示的数字。
*   返回这些数字之和。
*
* 输入：root = [1,0,1,0,1,0,1]
* 输出：22
* 解释：(100) + (101) + (110) + (111) = 4 + 5 + 6 + 7 = 22
* */
public class SumRootToLeaf_1022 {
    /*
    * DFS
    * */
    int ans;
    public int sumRootToLeaf(TreeNode root) {
        DFS(0 , root);
        return ans;
    }

    public void DFS(int sum , TreeNode root){
        if(root.left == null && root.right == null){
            ans += sum * 2 + root.val;
        }else{
            if(root.left != null){
                DFS(sum * 2 + root.val , root.left);
            }
            if(root.right != null){
                DFS(sum * 2 + root.val , root.right);
            }
        }
    }

    /*
    * BFS
    * */
    public int sumRootToLeaf2(TreeNode root) {
        Queue<TreeBit> queue = new LinkedList<>();
        queue.add(new TreeBit(0 , root));
        int res = 0;
        while(!queue.isEmpty()){
            TreeBit curNode = queue.poll();
            TreeNode node = curNode.root;
            //如果为叶子节点
            if(node.left == null && node.right == null){
                ans += curNode.sum * 2 + node.val;
            }else{
                if(node.left != null){
                    queue.add(new TreeBit(curNode.sum * 2 + node.val , node.left));
                }
                if(node.right != null){
                    queue.add(new TreeBit(curNode.sum * 2 + node.val , node.right));
                }
            }
        }
        return res;
    }
}

class TreeBit{
    int sum;
    TreeNode root;

    public TreeBit(int sum, TreeNode root) {
        this.sum = sum;
        this.root = root;
    }
}
