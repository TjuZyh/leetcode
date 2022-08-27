package com.leetcode.DailyCheckIn._0827;

import com.leetcode.TreeNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author zyh
 * @Date 2022/8/27 20:51
 * @Version 1.0
 */
public class WidthOfBinaryTree_662 {
    /*
    * 通过对节点进行index标号，每一层 最大的index - 最小的标号 + 1 即为当前的宽度
    *   创建元组包装treenode，其中记录当前节点的index
    *   当前节点为index ， 其左子节点为index * 2 ， 其右子节点为index * 2 + 1
    * */
    class Tuple{
        private TreeNode node;
        private Integer index;

        public Tuple(TreeNode node, Integer index) {
            this.node = node;
            this.index = index;
        }
    }
    public int widthOfBinaryTree(TreeNode root) {
        int ans = 0;
        Deque<Tuple> queue = new LinkedList<>();
        queue.add(new Tuple(root , 1));

        while(!queue.isEmpty()){
            int size = queue.size();
            int startIndex = queue.peek().index;
            int endIndex = 0;
            while(size > 0){
                --size;
                Tuple curTuple = queue.poll();
                TreeNode curNode = curTuple.node;
                Integer curIndex = curTuple.index;
                if(curNode.left != null){
                    queue.add(new Tuple(curNode.left , curIndex * 2));
                }
                if(curNode.right != null){
                    queue.add(new Tuple(curNode.right , curIndex * 2 + 1));
                }
                if(size == 0){
                    endIndex = curIndex;
                }
            }
            ans = Math.max(ans , endIndex - startIndex + 1);
        }
        return ans;
    }
}
