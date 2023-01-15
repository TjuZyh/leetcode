package com.leetcode.DMSXL.binaryTree;

import com.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author zyh
 * @Date 2023/1/15 16:34
 * @Version 1.0
 */
/*
* 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先, 最近公共祖先节点可以为节点本身
*   输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
*   输出: 6
* */
public class LowestCommonAncestor_235 {
    /*
    * 先利用BST的性质构造出根节点到p/q的路径，后分析路径，路径中最后一个重合的节点即为祖先
    * */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> pathP = getPath(root, p);
        List<TreeNode> pathQ = getPath(root, q);
        TreeNode ancestor = null;
        for(int i = 0; i < pathP.size() && i < pathQ.size(); i++) {
            if(pathP.get(i) == pathQ.get(i)) {
                ancestor = pathP.get(i);
            }else {
                break;
            }
        }
        return ancestor;
    }

    public List<TreeNode> getPath(TreeNode root, TreeNode target) {
        List<TreeNode> ans = new ArrayList<>();
        TreeNode node = root;
        while (node != target) {
            ans.add(node);
            if(node.val > target.val) {
                node = node.left;
            }else {
                node = node.right;
            }
        }
        ans.add(node);
        return ans;
    }

    /*
    * 针对于BST的公共祖先，自顶向下遍历，首个在p.val以及q.val之间的节点即为最近公共祖先
    * */
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if(root.val > p.val && root.val > q.val) return lowestCommonAncestor2(root.left, p, q);
        if(root.val < p.val && root.val < q.val) return lowestCommonAncestor2(root.right, p, q);
        return root;
    }
}
