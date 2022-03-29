package com.leetcode.java0328;

/*
* 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。如果是则返回 true，否则返回 false。
* 假设输入的数组的任意两个数字都互不相同
* */
public class VerifyPostorder {
    public boolean verifyPostorder(int[] postorder) {
        return recur(postorder , 0 , postorder.length - 1);
    }
    /*
    * 终止条件：当i >= j , 说明子节点数量 <= 1, 直接返回true
    * */
    public boolean recur(int[] postorder , int i , int j) {
        if(i >= j) return true;
        int p = i;
        //寻找第一个大于root的位置，即从该位置开始为右子树
        while(postorder[p] < postorder[j]) p++;
        //记录左子树与右子树的分界点
        int m = p;
        //继续遍历，右子树如果全部大于root，则应该遍历到末尾即j位置；否则不为二叉搜索树
        while(postorder[p] > postorder[j]) p++;
        /*
        * 1.判断该树是否为二叉搜索树
        * 2.递归判断左子树以及右子树是否为二叉搜索树
        * */
        return p == j && recur(postorder , i , m - 1) && recur(postorder , m , j - 1);
    }
}
