package com.leetcode.DMSXL.binaryTree;

import com.leetcode.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author zyh
 * @Date 2022/12/5 21:20
 * @Version 1.0
 */
/*
* 给定一个二叉树，判断它是否是高度平衡的二叉树
*   平衡二叉树：一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1
* */
public class IsBalanced_110 {
    /*
    * 自顶向下的递归：
    *   创建计算节点高度的API用于判断该节点为根的树是否为平衡二叉树
    *   自顶向下判断节点是否为平衡二叉树即可
    * 缺点：
    *   对于同一个节点，会重复的调用height函数，导致时间复杂度较高
    * */
    public boolean isBalanced(TreeNode root) {
        if(root == null) {
            return true;
        }else {
            return Math.abs(height(root.left) - height(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
        }
    }

    public int height(TreeNode root) {
        if(root == null) {
            return 0;
        }else {
            return Math.max(height(root.left), height(root.right)) + 1;
        }
    }

    /*
    * 自底向上的递归：则对于每个节点，函数height只会被调用一次
    *   对于当前遍历到的节点，先递归地判断其左右子树是否平衡，再判断以当前节点为根的子树是否平衡
    *   如果一棵子树是平衡的，则返回其高度（高度一定是非负整数），否则返回 −1。如果存在一棵子树不平衡，则整个二叉树一定不平衡
    * */
    public boolean isBalanced2(TreeNode root) {
        return getHeight(root) >= 0;
    }

    public int getHeight(TreeNode root) {
        if(root == null) return 0;
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);

        //若该节点的左右子树已经不满足平衡二叉树，或自己已经不符合则直接返回-1
        if(leftHeight == -1 || rightHeight == -1 || Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }else {
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }






}
