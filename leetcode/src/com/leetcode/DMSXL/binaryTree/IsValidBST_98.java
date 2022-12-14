package com.leetcode.DMSXL.binaryTree;

import com.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author zyh
 * @Date 2022/12/14 11:47
 * @Version 1.0
 */
/*
* 给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树
*   输入：root = [2,1,3]
*   输出：true
* */
public class IsValidBST_98 {
    /*
    * 这种递归不正确，只会判断当前层以及下一层的关系
    *   错误用例：[5,4,6,null,null,3,7]
    * */
    public boolean isValidBST(TreeNode root) {
        if(root == null) return true;
        if(root.left != null || root.right != null) {
            if(root.left != null && root.right != null) {
                return root.left.val < root.val && root.right.val > root.val;
            }else if(root.left != null) {
                return root.left.val < root.val;
            }else {
                return root.right.val > root.val;
            }
        }
        return isValidBST(root.left) && isValidBST(root.right);
    }

    /*
    * 递归：每轮递归确定一个范围，在范围之内则符合要求
    * */
    public boolean isValidBST2(TreeNode root) {
        return helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean helper(TreeNode node, long lower, long upper) {
        if(node == null) {
            return true;
        }
        if(node.val <= lower || node.val >= upper) {
            return false;
        }
        return helper(node.left, lower, node.val) && helper(node.right, node.val, upper);
    }

    /*
    * 利用BST的性质，即中序遍历应为递增序列
    * */
    long pre = Long.MIN_VALUE;
    public boolean isValidBST3(TreeNode root) {
        if(root == null) return true;

        boolean left = isValidBST3(root.left);

        //记录当前根节点的值，遍历右子节点一定要比当前的pre大
        if(root.val <= pre) return false;
        pre = root.val;

        boolean right = isValidBST3(root.right);

        return left && right;
    }

    /*
    * 先中序遍历，后检验是否为递增数列
    * */
    List<Integer> inorder = new ArrayList<>();
    public boolean isValidBST4(TreeNode root) {
        inorder(root);
        for(int i = 0; i < inorder.size() - 1; i++) {
            if(inorder.get(i + 1) <= inorder.get(i)) {
                return false;
            }
        }
        return true;
    }

    public void inorder(TreeNode node) {
        if(node == null) return;
        inorder(node.left);
        inorder.add(node.val);
        inorder(node.right);
    }
}
