package com.leetcode.DailyCheckIn._0823;

/**
 * @Author zyh
 * @Date 2022/8/23 14:24
 * @Version 1.0
 */
public class MovesToChessboard_782 {
    /*
    * 行与列之间的变换实际是互相独立的，二者互不影响，那么就可以将二维问题转化为一维问题
    *
    * 解题步骤：
    *   1. 检测矩阵合法性
    *   2. 计算步数
    * */
    public int movesToChessboard(int[][] board) {
        int n = board.length;
        int rowMask = 0 , colMask = 0;
        for(int i = 0 ; i < n ; i++){
            /*
            * |= 或运算 6 | 5 即 0110 | 0101 = 0111 = 7 （有1为1）
            * << 左移运算符 3 << 1 即 011 << 1 = 0110 = 6
            * */
            rowMask |= (board[0][i] << i);
            colMask |= (board[i][0] << i);
        }
        //System.out.println(rowMask + " " +  colMask);
        // ^ 异或运算 3 ^ 4 即 011 ^ 110 = 101
        int reverseRowMask = ((1 << n) - 1) ^ rowMask;
        int reverseColMask = ((1 << n) - 1) ^ colMask;
        //System.out.println(reverseRowMask + " " + reverseColMask);
        int rowCnt = 0 , colCnt = 0;
        for(int i = 0 ; i < n ; i++){
            int curRowMask = 0;
            int curColMask = 0;
            for(int j = 0 ; j < n ; j++){
                curRowMask |= (board[i][j] << j);
                curColMask |= (board[j][i] << j);
            }
            if(curRowMask != rowMask && curRowMask != reverseRowMask){
                return -1;
            }else if(curRowMask == rowMask){
                rowCnt++;
            }
            if(curColMask != colMask && curColMask != reverseColMask){
                return -1;
            }else if(curColMask == colMask){
                colCnt++;
            }
        }
        int rowMoves = getMoves(rowMask , rowCnt , n);
        int colMoves = getMoves(colMask , colCnt , n);
        return (rowMoves == -1) || (colMoves == -1) ? -1 : (rowMoves + colMoves);
    }

    public int getMoves(int mask , int count , int n){
        int ones = Integer.bitCount(mask);
        if((n & 1) == 1){
            if(Math.abs(n - 2 * ones) != 1 || Math.abs(n - 2 * count) != 1) {
                return -1;
            }
            if(ones == (n >> 1)){
                // 通过与0xAAAAAAAAA相与 可以去除掉奇数位上的1
                return n / 2 - Integer.bitCount(mask & 0xAAAAAAAA);
            }else {
                return (n + 1) / 2 - Integer.bitCount(mask & 0x55555555);
            }
        }else {
            if (ones != (n >> 1) || count != (n >> 1)) {
                return -1;
            }
            int count0 = n / 2 - Integer.bitCount(mask & 0xAAAAAAAA);
            int count1 = n / 2 - Integer.bitCount(mask & 0x55555555);
            return Math.min(count0, count1);
        }
    }

    public static void main(String[] args) {
        int[][] board = new int[][]{{0,1,1,0},{0,1,1,0},{1,0,0,1},{1,0,0,1}};
        new MovesToChessboard_782().movesToChessboard(board);
    }
}
