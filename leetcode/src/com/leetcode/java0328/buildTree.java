package com.leetcode.java0328;

import com.leetcode.TreeNode;

import java.util.HashMap;

/*
* 输入某二叉树的前序遍历和中序遍历的结果，请构建该二叉树并返回其根节点。
*   前序遍历：[3,9,2,1,7]
*   中序遍历：[9,3,1,2,7]
* */
public class buildTree {
    /*
    * 解题思路：
    *   1. 前序遍历的首元素为树的根节点node值
    *   2. 在中中序遍历中搜索根节点node的索引，可以将中序遍历划分为[左子树，根节点，右子树]
    *   3. 根据中序遍历的左子树的节点数量，可以将前序遍历划分为[根节点，左子树，右子树]
    * */
    int[] preorder;
    HashMap<Integer , Integer> map = new HashMap<>();
    //为了提升查找效率，直接用哈希表存储中序遍历的值与索引的映射
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        for(int i = 0 ; i < inorder.length ; i++){
            map.put(inorder[i] , i);
        }
        return recur(0 , 0 , inorder.length - 1);
    }

    TreeNode recur(int root , int left , int right){
        if(left > right) return null;
        TreeNode node = new TreeNode(preorder[root]);
        int i = map.get(preorder[root]);
        //左子树的根节点就是preorder的第一个，左边界就是left，右边界就是inorder找到的中间区分的位置并-1
        node.left = recur(root+1 , left , i - 1);
        //右子树的根节点就是preorder中根节点的位置+左子树的数量（i — left）+1
        //左边界就是i + 1
        //有边界就是right
        node.right = recur(root + i - left + 1 , i + 1 , right);
        return node;
    }
}
