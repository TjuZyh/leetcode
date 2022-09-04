package com.leetcode.DailyCheckIn._0904;

/**
 * @Author zyh
 * @Date 2022/9/4 19:21
 * @Version 1.0
 */
public class NumSpecial_1582 {
    public int numSpecial(int[][] mat) {
        int cnt = 0;
        int n = mat.length;
        int m = mat[0].length;
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(mat[i][j] == 1){
                    if(isPos(mat , i , j)){
                        cnt++;
                    }
                }
            }
        }
        return cnt;
    }

    public boolean isPos(int[][] mat , int x , int y){
        int n = mat.length;
        int m = mat[0].length;
        boolean flag = false;
        int cntX = 0;
        for(int i = 0 ; i < m ; i++){
            if(mat[x][i] == 1){
                cntX++;
            }
        }
        if(cntX > 1){
            return false;
        }
        int cntY = 0;
        for(int i = 0 ; i < n ; i++){
            if(mat[i][y] == 1){
                cntY++;
            }
        }
        if(cntY > 1){
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new NumSpecial_1582().numSpecial(new int[][]{{0, 0}, {0, 0}, {0, 1}}));
    }
}
