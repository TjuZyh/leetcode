package com.leetcode.DMSXL.binaryTree;

import com.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author zyh
 * @Date 2022/12/5 22:24
 * @Version 1.0
 */
public class BinaryTreePaths_257 {
    /*
    * 遍历到叶子节点时将该路径记录到ans中
    * */
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<>();
        DFS(root, paths, "");
        return paths;
    }

    public void DFS(TreeNode node, List<String> paths, String path) {
        if(node != null) {
            StringBuilder stringBuilder = new StringBuilder(path);
            stringBuilder.append(node.val);
            if(node.left == null && node.right == null) {
                paths.add(stringBuilder.toString());
            }else {
                stringBuilder.append("->");
                DFS(node.left, paths, stringBuilder.toString());
                DFS(node.right, paths, stringBuilder.toString());
            }
        }
    }
}
