package com.leetcode.offer.java0315;

import com.leetcode.TreeNode;
/*
* 输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)
*   B是A的子结构， 即 A中有出现和B相同的结构和节点值。
* */
public class IsSubStructure {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if(B == null || A == null){
            return false;
        }
        return isContain(A , B) || isSubStructure(A.left , B) || isSubStructure(A.right , B);
    }

    /*
    * isContain函数：
    *   终止条件：
    *       1. 节点B为空，证明B树已经匹配完成，因此返回true
    *       2. 节点A为空，证明遍历已经越过了A还没有匹配，因此返回false
    *       3. 当前A节点与B节点的值不同，匹配失败，返回false
    *   返回值：
    *       1. 判断A和B左右子节点是否相等
    * */
    public boolean isContain(TreeNode A, TreeNode B){
        if(B == null) return true;
        if(A == null || A.val != B.val) return false;
        //同时递归左右两个子节点
        return isContain(A.left , B.left) && isContain(A.right , B.right);
    }
}
