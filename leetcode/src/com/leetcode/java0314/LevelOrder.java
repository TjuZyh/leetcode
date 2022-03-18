package com.leetcode.java0314;

import com.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/*
* 从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。
 * */
public class LevelOrder {
    //BFS:广度优先搜索
    //BFS的实现经常借助队列的先入先出实现
    //维护一个队列，在遍历二叉树的时候一次将节点按次序入队，后依次写入数组即可
    public int[] levelOrder(TreeNode root) {
        //特判
        if(root == null){
            return new int[0];
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>(){{ add(root); }};
        ArrayList<Integer> arrayList = new ArrayList<>();
        //BFS
        while(!queue.isEmpty()){
            TreeNode curNode = queue.poll();
            arrayList.add(curNode.val);
            if(curNode.left != null){
                queue.add(curNode.left);
            }
            if(curNode.right != null){
                queue.add(curNode.right);
            }
        }
        int[] res = new int[arrayList.size()];
        /*for(int i = 0 ; i < arrayList.size() ; i++){
            res[i] = arrayList.get(i);
        }*/
        //stream流实现List转数组
        res = arrayList.stream().mapToInt(Integer::valueOf).toArray();
        return res;
    }
}
