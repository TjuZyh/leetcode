package com.leetcode.offer.java0405;

import com.leetcode.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Codec2 {
    /*
    * DFS : 前序遍历
    * */
    public String serialize(TreeNode root) {
        return reSerialize(root , "");
    }

    public String reSerialize(TreeNode root , String str){
        if(root == null){
            str += "null,";
        }else{
            str += String.valueOf(root.val) + ",";
            str = reSerialize(root.left , str);
            str = reSerialize(root.right , str);
        }
        return str;
    }

    public TreeNode deserialize(String data) {
        String[] dataArray = data.split(",");
        List<String> dataList = new LinkedList<String>(Arrays.asList(dataArray));
        return reDeserialize(dataList);
    }

    public TreeNode reDeserialize(List<String> dataList){
        if(dataList.get(0).equals("null")){
            dataList.remove(0);
            return null;
        }

        TreeNode root = new TreeNode(Integer.valueOf(dataList.get(0)));
        dataList.remove(0);
        root.left = reDeserialize(dataList);
        root.right = reDeserialize(dataList);

        return root;
    }
}
