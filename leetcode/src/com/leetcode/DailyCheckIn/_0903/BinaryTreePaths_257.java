package com.leetcode.DailyCheckIn._0903;

import com.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author zyh
 * @Date 2022/9/3 13:43
 * @Version 1.0
 */
public class BinaryTreePaths_257 {
    List<String> ans;
    public List<String> binaryTreePaths(TreeNode root) {
        ans = new ArrayList<>();
        dfs(root , "");
        return ans;
    }

    public void dfs(TreeNode root , String path){
        if(root == null) return;
        path += root.val;
        if(root.left == null && root.right == null){
            ans.add(path);
            return;
        }
        dfs(root.left , path + "->");
        dfs(root.right , path + "->");
    }
}
