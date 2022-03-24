package com.leetcode.java0322;

/*
* 定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。
* */
public class Exist {
    /*
    * DFS+剪枝
    *   1. 终止条件：
    *       返回false：1、行或列索引越界
    *                 2、当前矩阵元素与目标字符不同
    *                 3、当前矩阵元素已经访问
    *       返回true：k = len(word) - 1，即字符串word已经全部匹配
    *
    *   2. 递推工作：
    *       1. 标记当前矩阵
    *       2. 搜索下移单元格
    *       3. 还原当前矩阵元素
    * */
    public static boolean exist(char[][] board, String word) {
        char[] words = word.toCharArray();
        for(int i = 0 ; i < board.length ; i++){
            for(int j = 0 ; j < board[0].length ; j++){
                if(dfs(board , words , i , j , 0)) return true;
            }
        }
        return false;
    }

    public static boolean dfs(char[][] board , char[] word , int i , int j , int k){
        if(i >= board.length || i < 0 || j >= board[0].length || j < 0 || board[i][j] != word[k])
            return false;
        if(k == word.length - 1) return true;
        //代表此元素已访问过，防止之后搜索时重复访问。
        board[i][j] = '\0';
        boolean res = dfs(board , word , i + 1 , j , k + 1) || dfs(board, word, i - 1, j, k + 1) ||
                      dfs(board, word, i, j + 1, k + 1) || dfs(board, word, i , j - 1, k + 1);
        //还原当前矩阵元素
        board[i][k] = word[k];
        return res;
    }

    public static void main(String[] args) {
        String[][] arr = {{"A","B","C","E"},
                {"S","F","C","S"},
                {"A","D","E","E"},
        };
    }
}
