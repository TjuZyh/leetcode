package com.leetcode.DMSXL.greedy;

import com.leetcode.TreeNode;

/**
 * @Author zyh
 * @Date 2023/3/9 18:00
 * @Version 1.0
 */
/*
* 给定一个二叉树，我们在树的节点上安装摄像头。节点上的每个摄影头都可以监视其父对象、自身及其直接子对象。
*   计算监控树的所有节点所需的最小摄像头数量
* 输入：[0,0,null,0,0]
* 输出：1
* */
public class MinCameraCover_968 {
    //贪心思路，从叶子节点自底向上遍历树，先让叶子节点的父节点安摄像头，然后在依次隔层安装
    int result = 0;
    public int minCameraCover(TreeNode root) {
        //需要对根节点进行处理，如果为0，则需要加一个摄像头
        if(traversal(root) == 0) {
            result++;
        }
        return result;
    }

    /*
    * 将节点分为三种状态：无覆盖 0；有摄像头 1； 有覆盖 2；
    *   由于需要先访问叶子结点，则后序遍历树
    * */
    public int traversal(TreeNode node) {
        if(node == null) return 2;

        int left = traversal(node.left);
        int right = traversal(node.right);

        //该节点的左右叶子节点都覆盖，那么该节点为无覆盖
        if(left == 2 && right == 2) {
            return 0;
        //该节点的左叶子节点或右叶子节点无覆盖，那么该节点需要加一个摄像头，
        // 即只要其孩子无覆盖那么就要安一个摄像头
        }else if(left == 0 || right == 0) {
            result++;
            return 1;
        //剩余的情况是：叶子节点其中有一个安装了摄像头，那么该节点为被覆盖状态
        }else {
            return 2;
        }
    }
}
