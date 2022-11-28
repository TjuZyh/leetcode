package com.leetcode.DMSXL.binaryTree;

import com.leetcode.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author zyh
 * @Date 2022/11/28 23:46
 * @Version 1.0
 */
public class CountNodes_222 {
    public int countNodes(TreeNode root) {
        if(root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int ans = 0;
        while(!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if(cur.left != null) {
                queue.add(cur.left);
            }
            if(cur.right != null) {
                queue.add(cur.right);
            }
            ans++;
        }
        return ans;
    }

    public int countNodes2(TreeNode root) {
        if(root == null) return 0;

        int left = countNodes2(root.left);
        int right = countNodes2(root.right);

        return left + right + 1;
    }

    /*
    * 要充分利用完全二叉树的性质：
    *   1. 若height(left) == height(right)，说明左子树已满，个数为2 ^ height(left) - 1，再计算右子树个数即可
    *   2. 若height(left) != height(right)，说明右子树已满，个数为2 ^ height(right) - 1
    * */
    public int countNodes3(TreeNode root) {
        if(root == null) return 0;
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        if(leftHeight == rightHeight) {
            return (1 << leftHeight) + countNodes3(root.right);
        }else {
            return (1 << rightHeight) + countNodes3(root.left);
        }
    }

    public int getHeight(TreeNode node) {
        if(node == null) return 0;
        return Math.max(getHeight(node.left), getHeight(node.right)) + 1;
    }

}
