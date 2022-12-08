package com.leetcode.DMSXL.binaryTree;

import com.leetcode.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author zyh
 * @Date 2022/12/8 21:46
 * @Version 1.0
 */
/*
* 定两个整数数组 inorder 和 postorder ，其中 inorder 是二叉树的中序遍历， postorder 是同一棵树的后序遍历，
*   请你构造并返回这颗二叉树
* */
public class BuildTree_106 {
    //利用map存储，加快查找速度
    Map<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for(int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return DFS(inorder, 0, inorder.length , postorder, 0, postorder.length);
    }

    public TreeNode DFS(int[] inorder, int inBegin, int inEnd, int[] postorder, int postBegin, int postEnd) {
        if(inBegin >= inEnd || postBegin >= postEnd) {
            return null;
        }
        //找到中序遍历中根节点的位置，用于切分中序遍历，确定左右子区间
        //对于左子树：inorder[inBegin, rootIndex) postorder[postBegin, postBegin + rootIndex - inBegin) rootIndex - inBegin即为左子树的长度
        //对于右子树：inorder[rootIndex + 1, inEnd) postorder[postBegin + rootIndex - inBegin, postEnd - 1)
        int rootIndex = map.get(postorder[postEnd - 1]);
        TreeNode root = new TreeNode(inorder[rootIndex]);
        root.left = DFS(inorder, inBegin, rootIndex, postorder, postBegin, postBegin + rootIndex - inBegin);
        root.right = DFS(inorder, rootIndex + 1, inEnd, postorder, postBegin + rootIndex - inBegin, postEnd - 1);
        return root;
    }


}
