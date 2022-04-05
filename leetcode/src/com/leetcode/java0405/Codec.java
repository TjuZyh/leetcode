package com.leetcode.java0405;

import com.leetcode.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/*
* offer37：请实现两个函数，分别用来序列化和反序列化二叉树
* */
public class Codec {
    /*
    * BFS: 层序遍历
    * */
    // Encodes a tree to a single string.
    public static String serialize(TreeNode root) {
        if(root == null) return "[]";
        StringBuilder stringBuilder = new StringBuilder("[");
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode newNode = queue.poll();
            if(newNode != null){
                stringBuilder.append(newNode.val + ",");
                queue.add(newNode.left);
                queue.add(newNode.right);
            }else{
                stringBuilder.append("null,");
            }
        }
        //去除结尾的逗号
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        stringBuilder.append("]");
        return stringBuilder.toString();

    }

    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String data) {
        if(data.equals("[]")) return null;
        String[] dataArr = data.substring(1 , data.length() - 1) .split(",");
        TreeNode root = new TreeNode(Integer.parseInt(dataArr[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int i = 1;
        while(!queue.isEmpty()){
            TreeNode newNode = queue.poll();
            if(!dataArr[i].equals("null")){
                newNode.left = new TreeNode(Integer.parseInt(dataArr[i]));
                queue.add(newNode.left);
            }
            i++;
            if(!dataArr[i].equals("null")){
                newNode.right = new TreeNode(Integer.parseInt(dataArr[i]));
                queue.add(newNode.right);
            }
            i++;
        }
        return root;
    }

    public static void main(String[] args) {
        String str = "[1,2,3,null,null,4,5,null,null,null,null]";
        System.out.println(serialize(deserialize(str)));
    }
}
