package com.leetcode.offer.java0402;

/*
* offer29：输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字
* */
public class SpiralOrder {
    public int[] spiralOrder(int[][] matrix) {
        if(matrix.length == 0) return new int[0];
        //设立左、右、上、下边界以及数组游标x
        int l = 0 , r = matrix[0].length - 1 , t = 0 , b = matrix.length - 1 , x = 0;
        int[] res = new int[(r + 1) * (b + 1)];
        while(true){
            //从左往右遍历，将遍历完的上一行去掉，即++t
            for(int i = l ; i <= r ; i++) res[x++] = matrix[t][i];
            if(++t > b) break;
            //从上往下遍历，将遍历完的右一列去掉，即--r
            for(int i = t ; i <= b ; i++) res[x++] = matrix[i][r];
            if(--r < l) break;
            //从右往左遍历，将遍历完的下一行去掉，即--b
            for(int i = r ; i >= l ; i--) res[x++] = matrix[b][i];
            if(--b < t) break;
            //从下往上遍历，将遍历完的左一列去掉，即++l
            for(int i = b ; i >= t ; i--) res[x++] = matrix[i][l];
            if(++l > r) break;
        }
        return res;
    }
}
