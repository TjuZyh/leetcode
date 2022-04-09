package com.leetcode.offer.java0322;

/*
* 地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。
* 一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一格（不能移动到方格外），
* 也不能进入行坐标和列坐标的数位之和大于k的格子。例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。
* 请问该机器人能够到达多少个格子？
* */
public class MovingCount {
    /*
    * dfs：
    *   终止条件：
    *       1. 索引越界
    *       2. 索引数位和大于k
    *       3. 当前元素已被访问过
    *   初始化：
    *       创建二维boolean数组用于记录当前元素是否被访问
    * */
    public static int movingCount(int m, int n, int k) {
        boolean[][] visited = new boolean[m][n];
        return dfs(0 , 0 , m , n , k , visited);
    }

    public static int dfs(int i , int j , int m , int n , int k , boolean visited[][]){
        if(i < 0 || i >= m || j < 0 || j >= n || (getSum(i) + getSum(j) > k) || visited[i][j]){
            return 0;
        }
        visited[i][j] = true;
        return dfs(i - 1 , j ,m , n , k , visited) + dfs(i + 1 , j ,m , n , k , visited)+
                dfs(i , j - 1 ,m , n , k , visited) + dfs(i , j + 1 ,m , n , k , visited) + 1;
    }

    public static int getSum(int num){
        int sum = 0;
        while(num != 0){
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(movingCount(16, 8, 4));
    }

}
