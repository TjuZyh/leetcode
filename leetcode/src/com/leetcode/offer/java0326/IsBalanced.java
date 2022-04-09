package com.leetcode.offer.java0326;

import com.leetcode.TreeNode;

/*
* 输入一棵二叉树的根节点，判断该树是不是平衡二叉树。如果某二叉树中任意节点的左右子树的深度相差不超过1，
* 那么它就是一棵平衡二叉树。
* */
public class IsBalanced {
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        else return Math.abs(maxDepth(root.left) - maxDepth(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }

    public int maxDepth(TreeNode root){
        if(root == null) return 0;
        return Math.max(maxDepth(root.left) , maxDepth(root.right)) + 1;
    }
}
