package com.leetcode.java0315;

import com.leetcode.TreeNode;

/*
* 请实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和它的镜像一样，那么它是对称的。
*   对于对称二叉树的定义：
*       1. L.val=R.val ：即此两对称节点值相等
*       2. L.left.val=R.right.val ：即 L 的 左子节点 和 R 的 右子节点 对称；
*       3. L.right.val=R.left.val ：即 L 的 右子节点 和 R 的 左子节点 对称。
* */
public class IsSymmetric {

    public boolean isSymmetric(TreeNode root) {
        if(root == null) {
            return true;
        }
        return recur(root.left , root.right);
    }

    /*
    * 终止条件：
    *   当 L 和 R 同时越过叶节点： 此树从顶至底的节点都对称，因此返回 true；
    *   当 L 或 R 中只有一个越过叶节点： 此树不对称，因此返回 false；
    *   当节点 L 值 不等于 节点 R 值： 此树不对称，因此返回 false
    *
    * 返回值：
    *   判断两节点 (L.left 和 R.right)以及(L.right 和 R.left) 是否对称
    * */
    public boolean recur(TreeNode L , TreeNode R){
        if(L == null && R == null){
            return true;
        }
        if(L == null || R == null || L.val != R.val){
            return false;
        }
        return recur(L.left , R.right) && recur(L.right , R.left);
    }



}
