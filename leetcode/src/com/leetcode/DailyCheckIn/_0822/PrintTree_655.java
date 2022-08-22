package com.leetcode.DailyCheckIn._0822;

import com.leetcode.ListNode;
import com.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author zyh
 * @Date 2022/8/22 15:05
 * @Version 1.0
 */
public class PrintTree_655 {
    /*
    * 解题思路：
    *   1. 初始化输出矩阵，需要获取到树的高度，矩阵的大小为 m x n
    *       m : 树高 + 1
    *       n : 2 ^(树高 + 1) - 1
    *   2. BFS遍历树，将对应位置的输出矩阵变为节点值即可
    *       root节点的位置为：res[0][(n - 1) / 2]
    *       左子节点放置的位置为：res[r + 1][c - 2 << (treeHeight - r - 1)]
    *       右子节点放置的位置为：res[r + 1][c + 2 << (treeHeight - r - 1)]
    *
    * 小tips：
    *   1. 通过创建Tuple元组来封装Treenode，在其中记录当前节点需要放置的位置，利用数据结构记录数据
    *   2. 关于2的n次方，可以用位运算的方式实现，(1 << n)
    * */

    class Tuple {
        TreeNode node;
        int r;
        int c;

        public Tuple(TreeNode node, int r, int c) {
            this.node = node;
            this.r = r;
            this.c = c;
        }
    }

    public List<List<String>> printTree(TreeNode root) {
        int treeHeight = getTreeHeight(root);
        int m = treeHeight;
        int n = 1;
        for(int i = 0 ; i < m ; i++){
            n *= 2;
        }
        n = n - 1;

        // 初始化输出矩阵
        List<List<String>> ans = new ArrayList<>();
        for(int i = 0 ; i < m ; i++){
            List<String> line = new ArrayList<>();
            for(int j = 0 ; j < n ; j++){
                line.add("");
            }
            ans.add(line);
        }


        Queue<Tuple> queue = new LinkedList<>();
        queue.add(new Tuple(root , 0 , (n - 1) / 2));
        while(!queue.isEmpty()){
            Tuple curTuple = queue.poll();
            TreeNode node = curTuple.node;
            int r = curTuple.r , c = curTuple.c;
            //更改相应位置的值，即放置节点
            ans.get(r).set(c , Integer.toString(node.val));
            if(node.left != null){
                queue.add(new Tuple(node.left , r + 1 , c - (1 << m - r - 2)));
            }
            if(node.right != null){
                queue.add(new Tuple(node.right , r + 1 , c + (1 << m - r - 2)));
            }
        }
        return ans;
    }

    public static int getTreeHeight(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int ans = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            ++ans;
            while(size > 0){
                --size;
                TreeNode curNode = queue.poll();
                if(curNode.left != null){
                    queue.add(curNode.left);
                }
                if(curNode.right != null){
                    queue.add(curNode.right);
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode root2 = new TreeNode(2);
        TreeNode root3 = new TreeNode(2);
        root.left = root2;
        root.right = root3;

        new PrintTree_655().printTree(root).forEach(System.out::println);

    }
}
