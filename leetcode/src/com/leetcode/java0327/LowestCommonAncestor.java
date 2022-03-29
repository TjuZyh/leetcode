package com.leetcode.java0327;

import com.leetcode.TreeNode;

/*
* 定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
* 若 root 是 p,q 的 最近公共祖先 ，则只可能为以下情况之一：
*   1. p 和 q 在 root 的子树中，且分列 root 的 异侧（即分别在左、右子树中）；
*   2. p = root，且 q 在 root 的左或右子树中
*   3. q = root，且 p 在 root 的左或右子树中
* */
public class LowestCommonAncestor {
    /*
    * 循环搜索：
    *   1. 当p,q都在root的右子树中，则遍历至root.right;
    *   2. 否则，当p,q都在root的左子树中，则遍历至root.left;
    *   3. 否则，说明找到了最近公共祖先
    * */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while(root != null){
            //p和q都在root的右子树
            if(root.val < p.val && root.val < q.val) root = root.right;
            //p和q都在root的左子树
            else if(root.val > p.val && root.val > q.val) root = root.left;
            //在当前root的异侧，说明找到了最近公共祖先
            else break;
        }
        return root;
    }
}
