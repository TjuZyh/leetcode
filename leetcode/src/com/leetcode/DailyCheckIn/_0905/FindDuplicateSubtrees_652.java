package com.leetcode.DailyCheckIn._0905;

import com.leetcode.TreeNode;

import java.util.*;

/**
 * @Author zyh
 * @Date 2022/9/5 13:54
 * @Version 1.0
 */

/*
* 将子树进行序列化，后存储到hash表中，如果一个位置存入了两次，则子树重复
* */
public class FindDuplicateSubtrees_652 {

    private Map<String , TreeNode> map = new HashMap<>();
    private Set<TreeNode> ansSet = new HashSet<>();

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode curNode = queue.poll();
            addSubTreeToMap(curNode);
            if(curNode.left != null){
                queue.add(curNode.left);
            }
            if(curNode.right != null){
                queue.add(curNode.right);
            }
        }
        List<TreeNode> ans = new ArrayList<>();
        ans.addAll(ansSet);
        return ans;
    }

    public void addSubTreeToMap(TreeNode root){
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode curNode = queue.poll();
            if(curNode != null){
                sb.append(curNode.val + " ");
                queue.add(curNode.left);
                queue.add(curNode.right);
            }else {
                sb.append("null ");
            }
        }
        System.out.println(sb);
        if(map.get(sb.toString()) == null){
            map.put(sb.toString() , root);
        }else {
            //注意这里一定要向set中添加，map中存的root
            //因为此root与存的root一定不同，存入set时，会存两次
            //ansSet.add(root);
            ansSet.add(map.get(sb.toString()));
        }
    }

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(3);
        TreeNode root2 = new TreeNode(2);
        TreeNode root3 = new TreeNode(4);
        TreeNode root4 = new TreeNode(4);

        root1.left = root2;
        root1.right = root3;

        root2.left = root4;

        System.out.println(root3 == root4);

        new FindDuplicateSubtrees_652().findDuplicateSubtrees(root1);
    }


}
