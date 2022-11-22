package com.leetcode.DMSXL.binaryTree;

import com.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * @Author zyh
 * @Date 2022/11/22 14:32
 * @Version 1.0
 */
/*
* 二叉树迭代遍历
* */
public class TraversalBinaryTree2 {
    //入栈顺序：中右左
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if(root == null) return ans;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            ans.add(cur.val);
            //由于出栈顺序与入栈顺序是相反的，所以先右后左
            if(cur.right != null) {
                stack.add(cur.right);
            }
            if(cur.left != null) {
                stack.add(cur.left);
            }
        }
        return ans;
    }

    //入栈顺序：左-右
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if(root == null) return ans;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while(cur != null || !stack.isEmpty()) {
            if(cur != null) {
                stack.add(cur);
                cur = cur.left;
            }else {
                cur = stack.pop();
                ans.add(cur.val);
                cur = cur.right;
            }
        }
        return ans;
    }

    //入栈顺序：中左右 出栈顺序为中右左 后翻转结果，即左右中
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null){
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode node = stack.pop();
            result.add(node.val);
            if (node.left != null){
                stack.push(node.left);
            }
            if (node.right != null){
                stack.push(node.right);
            }
        }
        Collections.reverse(result);
        return result;
    }
}
