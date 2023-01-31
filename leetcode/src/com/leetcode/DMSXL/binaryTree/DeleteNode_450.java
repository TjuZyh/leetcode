package com.leetcode.DMSXL.binaryTree;

import com.leetcode.TreeNode;

/**
 * @Author zyh
 * @Date 2023/1/15 21:59
 * @Version 1.0
 */
/*
* 给定一个二叉搜索树的根节点 root 和一个值 key，删除二叉搜索树中的 key 对应的节点
*   输入：root = [5,3,6,2,4,null,7], key = 3
*   输出：[5,4,6,2,null,null,7]
* */
public class DeleteNode_450 {
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) return null;

        //如果删除的值小于根节点，则证明要删除的节点在左子树中，则递归左子树进行删除
        if(root.val > key) {
            root.left = deleteNode(root.left, key);
            return root;
        }

        if(root.val < key) {
            root.right = deleteNode(root.right, key);
            return root;
        }

        //找到目标节点，准备删除
        if(root.val == key) {
            //1. 如果该节点是叶子结点，直接删除
            if(root.left == null && root.right == null) {
                return null;
            }
            //2. 左叶子树为空，则删除后只剩下右子树
            if(root.left == null) {
                return root.right;
            }
            //3. 右子树为空，则删除后只剩下左子树
            if(root.right == null) {
                return root.left;
            }
            //4. 如果删除的节点存在左右子树
            TreeNode successor = root.right;
            while(successor.left != null) {
                successor = successor.left;
            }
            //删除successor，因为successor已经移动到根节点，不应该存在在root.right中
            root.right = deleteNode(root.right, successor.val);
            successor.right = root.right;
            successor.left = root.left;
            //删除了当前root节点，将successor作为当前新根
            return successor;
        }
        return root;
    }
}
